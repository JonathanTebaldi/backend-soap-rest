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

    public void adcionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public void removerAluno(UUID id) {
        Aluno alunoFound = listaAlunos.stream().filter(aluno -> aluno.getId().equals(id)).toList().get(0);
        listaAlunos.remove(alunoFound);
    }

    public Aluno atualizarAluno(UUID id, CadastroAlunoDTO dados) {
        Aluno alunoFound = listaAlunos.stream().filter(aluno -> aluno.getId().equals(id)).toList().get(0);
        for (Aluno aluno : listaAlunos) {
            if (aluno.getId().equals(alunoFound.getId())) {
                if (dados.nome() != null) {
                    aluno.setNome(dados.nome());
                }
                if (dados.idade() != null) {
                    aluno.setIdade(dados.idade());
                }
                if (dados.peso() != null) {
                    aluno.setPeso(dados.peso());
                }
                if (dados.altura() != null) {
                    aluno.setAltura(dados.altura());
                }
            }
        }
        return alunoFound;
    }

    public List<Aluno> listarAlunos() {
        return listaAlunos;
    }

    public Double calcularImc(UUID id) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getId().equals(id)) {
                double altura = aluno.getAltura();
                double peso = aluno.getPeso();
                return peso / (altura * altura);
            }
        }
        return null;
    }

    public String verificarImc(Double imc) {
        if (imc < 18.5)
            return "Magreza";
        if (imc > 18.5 && imc < 24.9)
            return "Normal";
        if (imc > 25.0 && imc < 29.9)
            return "Sobrepeso";
        if (imc > 30.0 && imc < 39.9)
            return "Obesidade";
        if (imc > 40.0)
            return "Obesidade Grave";
        return "Valor inválido";
    }
}
