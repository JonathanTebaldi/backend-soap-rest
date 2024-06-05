package br.edu.fema.api.domain.funcionario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroProfessorDTO(
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
