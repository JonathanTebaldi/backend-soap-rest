package br.edu.fema.api.domain.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroAlunoDTO(

        @NotBlank
        String nome,
        @NotNull
        Integer idade,
        @NotNull
        Double altura,
        @NotNull
        Double peso
) {
}
