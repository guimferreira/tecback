package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Premio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer ano;
    private String categoria;
    private String vencedor;

    public String listarVencedores(String categoria, Integer ano) {
        return "Vencedor na categoria " + this.categoria + " no ano " + this.ano + "é: " + this.vencedor;
    }
}
