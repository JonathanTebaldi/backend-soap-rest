package br.edu.fema.api.domain.aluno;

public record ListagemAlunosDTO (
        String nome,
        Integer idade,
        Double peso,
        Double altura
){
    public ListagemAlunosDTO(Aluno aluno) {
        this(aluno.getNome(), aluno.getIdade(), aluno.getPeso(),aluno.getAltura());
    }
}
