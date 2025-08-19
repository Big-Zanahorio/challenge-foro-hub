package com.carlos.challenge_foro_hub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name ="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private boolean activo = true;

    @Column(name = "autor_id")
    private Long autorId;

    @Column(name = "curso_id")
    private Long cursoId;

    public Topico(TopicoRegistroDTO datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autorId = datos.autorId();
        this.cursoId = datos.cursoId();
    }
}
