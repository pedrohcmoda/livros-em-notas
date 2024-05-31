package com.avalsupport.crud.controllers;

import com.avalsupport.crud.models.ComentarioModel;
import com.avalsupport.crud.models.LivroModel;
import com.avalsupport.crud.repositories.ComentarioRepository;
import com.avalsupport.crud.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/comentario")
@CrossOrigin(origins = "*")
public class ComentariosController {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/{livroId}")
    public ResponseEntity<Object> createComentario(@PathVariable (value="livroId") UUID livroId, @RequestBody ComentarioModel comentario) {
        Optional<LivroModel> livro = livroRepository.findById(livroId);
        if(livro.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A publicação não foi encontrada");
        }
        comentario.setLivro(livro.orElse(null));
        ComentarioModel savedComentario = comentarioRepository.save(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComentario);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{comentarioId}")
    public ResponseEntity<String> deleteComentario(@PathVariable (value="comentarioId") UUID comentarioId) {
        Optional<ComentarioModel> comentario = comentarioRepository.findById(comentarioId);
        if(comentario.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Comentario não encontrado.");
        }
        comentarioRepository.delete(comentario.orElse(null));
        return ResponseEntity.status(HttpStatus.OK).body("Comentario excluido com sucesso.");
    }
}
