package br.com.fujideia.iesp.tecback.model;

import br.com.fujideia.iesp.tecback.model.dto.FilmeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "diretor")
    private List<Filme> filmesDirigidos;
}