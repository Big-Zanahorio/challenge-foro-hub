package com.carlos.challenge_foro_hub.domain.usuario;

import java.util.List;

public record UsuarioObtenerDTO(
        Long id,
        String nombre,
        String correoElectronico,
        List<String> perfiles
) {
    public UsuarioObtenerDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                usuario.getPerfiles()
                        .stream()
                        .map(p -> p.getNombre())
                        .toList()
        );
    }
}
