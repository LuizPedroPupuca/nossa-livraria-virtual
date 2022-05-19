package br.com.zup.edu.livraria.livro;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class LivroRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String resumo;

    @NotBlank
    private String autor;

    @NotBlank
    private String isbn;

    @NotNull
    private List<Exemplar> exemplares;

    public LivroRequest() {
    }

    public LivroRequest(String nome, String resumo, String autor, String isbn, List<Exemplar> exemplares) {
        this.nome = nome;
        this.resumo = resumo;
        this.autor = autor;
        this.isbn = isbn;
        this.exemplares = exemplares;
    }

    public String getNome() {
        return nome;
    }

    public String getResumo() {
        return resumo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public Livro toModel() {
        return new Livro(exemplares, nome, resumo, autor, isbn);
    }
}
