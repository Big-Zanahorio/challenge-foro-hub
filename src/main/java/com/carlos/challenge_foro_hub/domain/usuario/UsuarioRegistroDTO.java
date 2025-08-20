package com.carlos.challenge_foro_hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRegistroDTO(
        @NotBlank String nombre,
        @Email String correoElectronico,
        @NotBlank String contrasena
) {}
