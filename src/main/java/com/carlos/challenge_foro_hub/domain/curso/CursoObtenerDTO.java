package com.carlos.challenge_foro_hub.domain.curso;

public record CursoObtenerDTO(
        Long id,
        String nombre,
        String categoria
) {
    public CursoObtenerDTO(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
