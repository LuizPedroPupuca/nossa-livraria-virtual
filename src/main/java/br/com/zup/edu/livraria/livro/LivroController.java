package br.com.zup.edu.livraria.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid LivroRequest livroRequest,
                                      UriComponentsBuilder uriComponentsBuilder){
        Livro livro = livroRequest.toModel();
        livroRepository.save(livro);
        URI location = uriComponentsBuilder.path("/video/{id}")
                .buildAndExpand(livro.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
