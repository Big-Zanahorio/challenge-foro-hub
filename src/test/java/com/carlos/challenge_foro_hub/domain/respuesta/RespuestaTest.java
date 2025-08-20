package com.carlos.challenge_foro_hub.domain.respuesta;

import com.carlos.challenge_foro_hub.domain.topico.Topico;
import com.carlos.challenge_foro_hub.domain.usuario.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RespuestaTest {

    @Test
    void constructorConDTO_asignaValoresCorrectamente() {
        Topico topico = new Topico();
        Usuario autor = new Usuario();
        RespuestaRegistroDTO dto = new RespuestaRegistroDTO("Mensaje", 1L, 1L, "Solución");

        Respuesta respuesta = new Respuesta(dto, topico, autor);

        assertEquals("Mensaje", respuesta.getMensaje());
        assertEquals("Solución", respuesta.getSolucion());
        assertEquals(topico, respuesta.getTopico());
        assertEquals(autor, respuesta.getAutor());
    }

    @Test
    @DisplayName("Actualiza solo campos no nulos")
    void actualizarInformacion() {
        Respuesta respuesta = new Respuesta();
        respuesta.actualizarInformacion(new RespuestaRegistroDTO("Nuevo mensaje", null, 1L, null));

        assertEquals("Nuevo mensaje", respuesta.getMensaje());
        assertNull(respuesta.getSolucion());
    }
}