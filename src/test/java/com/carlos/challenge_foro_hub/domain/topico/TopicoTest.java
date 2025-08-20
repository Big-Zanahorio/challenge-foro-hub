package com.carlos.challenge_foro_hub.domain.topico;

import com.carlos.challenge_foro_hub.domain.curso.Curso;
import com.carlos.challenge_foro_hub.domain.usuario.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopicoTest {

    @Test
    @DisplayName("Asigna valores correctamente")
    void constructorConDTOEscenario1() {
        Usuario autor = new Usuario();
        Curso curso = new Curso(new com.carlos.challenge_foro_hub.domain.curso.CursoRegistroDTO("Java", "Backend"));
        TopicoRegistroDTO dto = new TopicoRegistroDTO("Título", "Mensaje", 1L, 1L);

        Topico topico = new Topico(dto, autor, curso);

        assertEquals("Título", topico.getTitulo());
        assertEquals("Mensaje", topico.getMensaje());
        assertEquals(autor, topico.getAutor());
        assertEquals(curso, topico.getCurso());
    }

    @Test
    @DisplayName("Actualiza solo campos no nulos")
    void actualizarInformacion() {
        Usuario autor = new Usuario();
        Curso curso = new Curso(new com.carlos.challenge_foro_hub.domain.curso.CursoRegistroDTO("Spring", "Backend"));
        Topico topico = new Topico(new TopicoRegistroDTO("Viejo título", "Viejo mensaje", 1L, 1L), autor, curso);

        Curso nuevoCurso = new Curso(new com.carlos.challenge_foro_hub.domain.curso.CursoRegistroDTO("Docker", "DevOps"));
        topico.actualizarInformacion(new TopicoRegistroDTO("Nuevo título", null, 1L, 1L), nuevoCurso);

        assertEquals("Nuevo título", topico.getTitulo());
        assertEquals("Viejo mensaje", topico.getMensaje());
        assertEquals(nuevoCurso, topico.getCurso());
    }
}