package com.avalsupport.crud.dtos;

import com.avalsupport.crud.models.LivroModel;
import jakarta.validation.constraints.NotBlank;

public record ComentarioDto (@NotBlank String comentario, int pagina, LivroModel livro){
}
