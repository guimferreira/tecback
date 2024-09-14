package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.repository.CriticaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/critica")
public class CriticaController {
    private final CriticaRepository criticaRepository;
}
