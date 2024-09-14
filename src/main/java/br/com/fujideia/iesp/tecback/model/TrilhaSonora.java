package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class TrilhaSonora {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String compositor;
    private String filme;
    @ElementCollection
    private List<String> faixas;
    private Integer duracaoTotal = 0; // Em segundos

    public void adicionarFaixa(String faixa, int duracao) {
        this.faixas.add(faixa);
        this.duracaoTotal += duracao; // Já calcula a duração total. Dispensa a criação do método calcularDuracaoTotal()
    }

}
