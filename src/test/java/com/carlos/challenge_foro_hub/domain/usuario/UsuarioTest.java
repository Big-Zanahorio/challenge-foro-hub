package com.carlos.challenge_foro_hub.domain.usuario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    @DisplayName("Asigna valores correctamente")
    void constructorConDTO() {
        UsuarioRegistroDTO dto = new UsuarioRegistroDTO("Carlos", "carlos@test.com", "1234");
        Usuario usuario = new Usuario(dto);

        assertEquals("Carlos", usuario.getNombre());
        assertEquals("carlos@test.com", usuario.getCorreoElectronico());
        assertEquals("1234", usuario.getContrasena());
    }

    @Test
    @DisplayName("Actualiza solo campos no nulos")
    void actualizarInformacion() {
        Usuario usuario = new Usuario(new UsuarioRegistroDTO("Carlos", "carlos@test.com", "1234"));
        usuario.actualizarInformacion(new UsuarioRegistroDTO(null, "nuevo@test.com", null));

        assertEquals("Carlos", usuario.getNombre());
        assertEquals("nuevo@test.com", usuario.getCorreoElectronico());
        assertEquals("1234", usuario.getContrasena());
    }
}