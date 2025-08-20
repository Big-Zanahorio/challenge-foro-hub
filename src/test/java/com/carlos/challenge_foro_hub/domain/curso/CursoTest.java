package com.carlos.challenge_foro_hub.domain.curso;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CursoTest {
    @Test
    @DisplayName("Asigna valores correctamente")
    void constructorConDTOEscenario1() {
        CursoRegistroDTO dto = new CursoRegistroDTO("Java", "Programación");
        Curso curso = new Curso(dto);

        assertEquals("Java", curso.getNombre());
        assertEquals("Programación", curso.getCategoria());
    }

    @Test
    @DisplayName("Actualiza solo campos nulos")
    void actualizarInformacionEscenario1() {
        Curso curso = new Curso(new CursoRegistroDTO("Spring", "Backend"));

        curso.actualizarInformacion(new CursoRegistroDTO(null, "Web"));

        assertEquals("Spring", curso.getNombre());
        assertEquals("Web", curso.getCategoria());
    }
}