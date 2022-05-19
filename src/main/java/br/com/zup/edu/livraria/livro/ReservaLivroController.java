package br.com.zup.edu.livraria.livro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/reservar-livro/{isbn}")
public class ReservaLivroController {
    private final ExemplarRepository repository;

    public ReservaLivroController(ExemplarRepository repository) {
        this.repository = repository;
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<?> reservar(@PathVariable String isbn) {
        Exemplar exemplar = repository.findFirstByReservadoIsFalseAndLivro_IsbnEquals(isbn)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe exemplar cadastrado para este ISBN"));
        if (exemplar.isReservado()){
            return ResponseEntity.unprocessableEntity().build();
        }

        exemplar.reservar();

        repository.save(exemplar);

        return ResponseEntity.noContent().build();
    }
}
