package com.avalsupport.crud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name= "livros")
public class LivroModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLivro;
    private String titulo;
    private String editora;
    private String autor;
    private String isbn;
    private int ano;
    private String edicao;
    private boolean emprestado;
    private Date fimLeitura;

    @OneToMany(mappedBy = "livro", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private Set<ComentarioModel> comentarios = new HashSet<>(); 

    public UUID getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(UUID idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public Date getFimLeitura() {
        return fimLeitura;
    }

    public void setFimLeitura(Date fimLeitura) {
        this.fimLeitura = fimLeitura;
    }

    public Set<ComentarioModel> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<ComentarioModel> comentarios) {
        this.comentarios = comentarios;
    }
}