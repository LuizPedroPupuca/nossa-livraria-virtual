package br.com.zup.edu.livraria.livro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
    Optional<Exemplar> findFirstByReservadoIsFalseAndLivro_IsbnEquals(String isbn);
}
