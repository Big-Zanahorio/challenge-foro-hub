package com.carlos.challenge_foro_hub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record CursoRegistroDTO(
        @NotBlank String nombre,
        @NotBlank String categoria
) {

}