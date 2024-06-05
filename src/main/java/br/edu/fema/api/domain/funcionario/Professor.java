package br.edu.fema.api.domain.funcionario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    private UUID id;
    private String nome;
    private Integer idade;
    private Double peso;
    private Double altura;
}
