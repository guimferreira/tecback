package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.AtorDTO;
import br.com.fujideia.iesp.tecback.service.AtorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ator")
@Slf4j
public class AtorController {
    private final AtorService atorService;

    @PostMapping
    public ResponseEntity<AtorDTO> criarAtor(@RequestBody AtorDTO atorDTO) {
        log.info("Chamando criarAtor no AtorController com dados: {}", atorDTO);
        AtorDTO atorCriado = atorService.criarAtor(atorDTO);
        return ResponseEntity.ok(atorCriado);
    }

    @GetMapping
    public ResponseEntity<List<AtorDTO>> listarAtores() {
        log.info("Chamando listarAtores no AtorController");
        List<AtorDTO> atores = atorService.listarAtores();
        return ResponseEntity.ok(atores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtorDTO> buscarAtorPorId(@PathVariable Long id) {
        log.info("Chamando buscarAtorPorId no AtorController com id: {}", id);
        Optional<AtorDTO> ator = atorService.buscarAtorPorId(id);
        return ator.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtorDTO> atualizarAtor(@PathVariable Long id, @RequestBody AtorDTO atorDTO) {
        log.info("Chamando atualizarAtor no AtorController com o id: {}", id);
        Optional<AtorDTO> atorAtualizado = atorService.atualizarAtor(id, atorDTO);
        return atorAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtor(@PathVariable Long id) {
        log.info("Chamando deletarAtor no AtorController com id: {}", id);
        boolean deletado = atorService.deletarAtor(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
