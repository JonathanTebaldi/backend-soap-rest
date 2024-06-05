package br.edu.fema.api.domain.aluno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    private UUID id;
    private String nome;
    private Integer idade;
    private Double peso;
    private Double altura;

    public Aluno(CadastroAlunoDTO dados){
        this.id = UUID.randomUUID();
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.peso = dados.peso();
        this.altura = dados.altura();
    }

}
