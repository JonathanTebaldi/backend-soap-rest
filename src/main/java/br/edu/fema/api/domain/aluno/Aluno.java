package br.edu.fema.api.domain.aluno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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
    private List<Aluno> listaAlunos;

    public Aluno(CadastroAlunoDTO dados){
        this.id = UUID.randomUUID();
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.peso = dados.peso();
        this.altura = dados.altura();
    }

    public void atualizarAluno(CadastroAlunoDTO dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.idade() != null){
            this.idade = dados.idade();
        }
        if(dados.peso() != null){
            this.peso = dados.peso();
        }
        if(dados.altura() != null){
            this.altura = dados.altura();
        }
    }

    public void adcionarAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    public void removerAluno(Aluno aluno){
        listaAlunos.remove(aluno);
    }

}
