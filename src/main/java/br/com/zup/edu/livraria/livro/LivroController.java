package br.com.zup.edu.livraria.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid LivroRequest livroRequest){
        Livro livro = livroRequest.toModel();
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }
}
