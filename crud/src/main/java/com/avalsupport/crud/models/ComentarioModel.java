package com.avalsupport.crud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "comentarios")
public class ComentarioModel implements Serializable {

    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idComentario;
    private String comentario;
    private int pagina;

    @ManyToOne()
    @JoinColumn(name = "idLivro", nullable = false)
    @JsonBackReference
    private LivroModel livro;

    public UUID getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(UUID idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public LivroModel getLivro() {
        return livro;
    }

    public void setLivro(LivroModel livro) {
        this.livro = livro;
    }
}
