package com.carlos.challenge_foro_hub.domain.topico;

public record TopicoRegistroDTO(
        String titulo,
        String mensaje,
        Long autorId,
        Long cursoId
) {
}
