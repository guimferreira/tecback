package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Produtor;
import br.com.fujideia.iesp.tecback.repository.ProdutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtor")
public class ProdutorController {
    private final ProdutorRepository produtorRepository;

    @PostMapping
    public Produtor adicionarProdutor(Produtor produtor){
        return produtorRepository.save(produtor);
    }

    @GetMapping
    public List<Produtor> listarProdutores() {
        return produtorRepository.findAll();
    }

    @GetMapping("/nome")
    public ResponseEntity<Produtor> buscarPorNome(@PathVariable String nome) {
        Optional<Produtor> produtor = produtorRepository.findByNome(nome);
        if (produtor.isPresent()) {
            return ResponseEntity.ok(produtor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
