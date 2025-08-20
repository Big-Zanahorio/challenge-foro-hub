package com.carlos.challenge_foro_hub.domain.respuesta;

import java.time.LocalDateTime;

public record RespuestaObtenerDTO(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long topicoId,
        Long autorId,
        String solucion
) {
    public RespuestaObtenerDTO(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getTopico().getId(),
                respuesta.getAutor().getId(),
                respuesta.getSolucion()
        );
    }
}
