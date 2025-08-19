package com.carlos.challenge_foro_hub.domain.respuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    // Aquí puedes agregar consultas personalizadas en el futuro si las necesitas
}
