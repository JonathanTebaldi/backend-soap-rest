package br.edu.fema.api.service;

import br.edu.fema.api.domain.aluno.Aluno;
import br.edu.fema.api.domain.aluno.CadastroAlunoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    private List<Aluno> listaAlunos = new ArrayList<>();

    public void adcionarAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    public void removerAluno(UUID id){
        listaAlunos.remove(id);
    }

    public void atualizarAluno(UUID id, CadastroAlunoDTO dados){
        for(Aluno aluno: listaAlunos){
            if(id == aluno.getId()){
                if(dados.nome() != null){
                    aluno.setNome(dados.nome());
                }
                if(dados.idade() != null){
                    aluno.setIdade(dados.idade());
                }
                if(dados.peso() != null){
                    aluno.setPeso(dados.peso());
                }
                if(dados.altura() != null){
                    aluno.setAltura(dados.altura());
                }
            }
        }
    }

    public List<Aluno> listarAlunos(){
        return listaAlunos;
    }

    public Double calcularImc(UUID id){
        for(Aluno aluno: listaAlunos){
            if(aluno.getId().equals(id)){
                double altura = aluno.getAltura();
                double peso = aluno.getPeso();
                return (altura * altura) / peso;
            }
        }
        return null;
    }
}
