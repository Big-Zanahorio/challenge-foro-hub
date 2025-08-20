package com.carlos.challenge_foro_hub.domain.respuesta;

import com.carlos.challenge_foro_hub.domain.topico.Topico;
import com.carlos.challenge_foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    private String solucion;

    public Respuesta(@Valid RespuestaRegistroDTO datos, Topico topico, Usuario usuario) {
        this.mensaje = datos.mensaje();
        this.topico = topico;
        this.autor = usuario;
        this.solucion = datos.solucion();
    }

    public void actualizarInformacion(RespuestaRegistroDTO datos) {
        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if(datos.solucion() != null){
            this.solucion = datos.solucion();
        }
    }
}

