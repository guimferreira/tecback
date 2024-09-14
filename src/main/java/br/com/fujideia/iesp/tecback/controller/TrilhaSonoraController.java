package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.TrilhaSonora;
import br.com.fujideia.iesp.tecback.repository.TrilhaSonoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("trilha_sonora")
public class TrilhaSonoraController {
    private final TrilhaSonoraRepository trilhaSonoraRepository;

    @GetMapping
    public List<TrilhaSonora> listarTrilhasSonoras() {
        return trilhaSonoraRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaSonora> buscarTrilhaSonoraPorId(@PathVariable Long id) {
        Optional<TrilhaSonora> trilhaSonora = trilhaSonoraRepository.findById(id);
        if (trilhaSonora.isPresent()) {
            return ResponseEntity.ok(trilhaSonora.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TrilhaSonora criarTrilha(TrilhaSonora trilhaSonora) {
        return trilhaSonoraRepository.save(trilhaSonora);
    }

    @PostMapping("/{id}/adicionar_faixa")
    public ResponseEntity<TrilhaSonora> adicionarFaixa(
            @PathVariable Long id,
            @RequestParam String faixa,
            @RequestParam int duracao) {
        TrilhaSonora trilhaSonora = trilhaSonoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha Sonora não encontrada"));

        trilhaSonora.adicionarFaixa(faixa, duracao);
        trilhaSonoraRepository.save(trilhaSonora);

        return ResponseEntity.ok(trilhaSonora);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarTrilhaSonora(@PathVariable Long id) {
        if (trilhaSonoraRepository.existsById(id)) {
            trilhaSonoraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
