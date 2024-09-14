package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.repository.CinematografiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinematografia")
public class CinematografiaController {
    private final CinematografiaRepository cinematografiaRepository;
}
