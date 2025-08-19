package com.carlos.challenge_foro_hub.domain.curso;

import jakarta.persistence.*;
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

    public void actualizarInformacion(Curso datos) {

        if(datos.getNombre() != null) {
            this.nombre = datos.getNombre();
        }
        if(datos.getCategoria() != null) {
            this.categoria = datos.getCategoria();
        }
    }
}
