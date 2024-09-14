package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.dto.DiretorDTO;
import br.com.fujideia.iesp.tecback.service.DiretorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/diretor")
@Slf4j
public class DiretorController {
    private final DiretorService diretorService;

    @PostMapping
    public ResponseEntity<DiretorDTO> criarDiretor(@RequestBody DiretorDTO diretorDTO) {
        log.info("Chamando criarDiretor no DiretorCOntroller com os dados: {}", diretorDTO);
        DiretorDTO diretorCriado = diretorService.criarDiretor(diretorDTO);
        return ResponseEntity.ok(diretorCriado);
    }

    @GetMapping
    public ResponseEntity<List<DiretorDTO>> listarDiretores() {
        log.info("Chamando listarDiretores no DiretorController");
        List<DiretorDTO> diretores = diretorService.listarDiretores();
        return ResponseEntity.ok(diretores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorDTO> buscarDiretorPorId(@PathVariable Long id) {
        log.info("Chamando buscarDiretorPorId no DiretorController com id: {}", id);
        Optional<DiretorDTO> diretor = diretorService.buscarDiretorPorId(id);
        return diretor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiretorDTO> atualizarDiretor(@PathVariable Long id, @RequestBody DiretorDTO diretorDTO) {
        log.info("Chamando atualilzarDiretor no DiretorController com id: {}", id);
        Optional<DiretorDTO> diretorAtualizado = diretorService.atualizarDiretor(id, diretorDTO);
        return diretorAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiretor(@PathVariable Long id) {
        log.info("Chamando deletarDiretor no DiretorController com id: {}", id);
        boolean deletado = diretorService.deletarDiretor(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
