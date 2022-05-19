package br.com.zup.edu.livraria.livro;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.util.List;
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="livro_id")
    private List<Exemplar> exemplares;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String resumo;


    @Column(nullable = false)
    private String autor;


    @Column(nullable = false)
    @org.hibernate.validator.constraints.ISBN(type = org.hibernate.validator.constraints.ISBN.Type.ANY)
    private String isbn;




    public Livro(List<Exemplar> exemplares, String nome, String resumo, String autor, String isbn) {
        this.exemplares = exemplares;
        this.nome = nome;
        this.resumo = resumo;
        this.autor = autor;
        this.isbn = isbn;
    }

    /**
     * @deprecated construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Livro() {
    }

    public Long getId() {
        return id;
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
}
