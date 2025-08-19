package com.carlos.challenge_foro_hub.domain.topico;

import java.time.LocalDateTime;

public record TopicoObtenerDTO(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        boolean activo,
        Long autorId,
        Long cursoId
) {
    public TopicoObtenerDTO(Topico topico){
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.isActivo(),
                topico.getAutorId(),
                topico.getCursoId()
        );
    }
}
