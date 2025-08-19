package com.carlos.challenge_foro_hub.domain.topico;

import java.time.LocalDateTime;

public record TopicoObtenerDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        boolean status,
        Long autorId,
        Long cursoId
) {
}
