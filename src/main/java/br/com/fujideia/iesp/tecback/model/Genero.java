package br.com.fujideia.iesp.tecback.model;

import br.com.fujideia.iesp.tecback.model.dto.FilmeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "generos")
    private List<Filme> filmes;
}