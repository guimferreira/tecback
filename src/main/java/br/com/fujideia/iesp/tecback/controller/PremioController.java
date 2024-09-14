package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Premio;
import br.com.fujideia.iesp.tecback.repository.PremioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/premio")
public class PremioController {
    private final PremioRepository premioRepository;

    @GetMapping
    public List<Premio> listarPremiados() {
        return premioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Premio> buscarPorId(@PathVariable Long id) {
        Optional<Premio> premio = premioRepository.findById(id);
        if (premio.isPresent()) {
            return ResponseEntity.ok(premio.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar_vencedores")
    public ResponseEntity<Premio> listarVencedores(
            @RequestParam String categoria,
            @RequestParam Integer ano) {
        Premio premio = premioRepository.findByCategoriaAno(categoria, ano)
                .orElseThrow(() -> new RuntimeException("Ano sem vencedor nessa categoria."));

        premio.listarVencedores(categoria, ano);

        return ResponseEntity.ok(premio);
    }

    @PostMapping
    public Premio incluirPremio(Premio premio) {
        return premioRepository.save(premio);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPremio(@PathVariable Long id) {
        if (premioRepository.existsById(id)) {
            premioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
