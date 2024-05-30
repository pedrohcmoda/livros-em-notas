package com.avalsupport.crud.controllers;

import com.avalsupport.crud.dtos.LivroDto;
import com.avalsupport.crud.models.LivroModel;
import com.avalsupport.crud.repositories.LivroRepository;

import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
@CrossOrigin(origins = "*")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<LivroModel> inserirProduto(@RequestBody @Valid LivroDto livroDto){
        LivroModel livroModel = new LivroModel();
        BeanUtils.copyProperties(livroDto, livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livroModel));
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> consultarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultarUm(@PathVariable (value="id") UUID id) {
        Optional<LivroModel> livroModelOptional = livroRepository.findById(id);
        if(livroModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro especificado não existe.");
        }
        LivroModel livroModel = livroModelOptional.get();
        livroModel.getComentarios().size();
        return ResponseEntity.status(HttpStatus.OK).body(livroModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable (value="id") UUID id) {
        Optional<LivroModel> livroModel = livroRepository.findById(id);
        if(livroModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro especificado não existe.");
        }
        livroRepository.delete(livroModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Livro excluído com sucesso.");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object>
    updateProduct(@PathVariable(value="id") UUID id, @RequestBody @Valid LivroDto livroDto) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        if(livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro especificado não existe.");
        }
        var livroModel = livro.get();
        BeanUtils.copyProperties(livroDto, livroModel);
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livroModel));
    }
}
