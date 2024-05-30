package com.avalsupport.crud.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record LivroDto(@NotBlank String titulo, String editora, String autor, String isbn, int ano, String edicao, boolean emprestado, Date fimLeitura ) {

}
