package com.carlos.challenge_foro_hub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String categoria;

    public Curso(@Valid CursoRegistroDTO datos) {
        this.nombre = datos.nombre();
        this.categoria = datos.categoria();
    }

    public void actualizarInformacion(CursoRegistroDTO datos) {

        if(datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if(datos.categoria() != null) {
            this.categoria = datos.categoria();
        }
    }
}
