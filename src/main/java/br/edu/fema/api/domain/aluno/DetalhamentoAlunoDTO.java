package br.edu.fema.api.domain.aluno;

import java.util.UUID;

public record DetalhamentoAlunoDTO(
        UUID id,
        String nome,
        Integer idade,
        Double peso,
        Double altura
) {
    public DetalhamentoAlunoDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getPeso(),aluno.getAltura());
    }
}
