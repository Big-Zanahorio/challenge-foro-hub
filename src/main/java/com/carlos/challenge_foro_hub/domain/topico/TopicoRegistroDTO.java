package com.carlos.challenge_foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRegistroDTO(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long autorId,
        @NotNull Long cursoId
) {

}
