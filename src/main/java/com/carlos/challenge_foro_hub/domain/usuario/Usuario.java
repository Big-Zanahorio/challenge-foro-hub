package com.carlos.challenge_foro_hub.domain.usuario;

import com.carlos.challenge_foro_hub.domain.perfil.Perfil;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "correo_electronico", unique = true, nullable = false)
    private String correoElectronico;

    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_perfiles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<Perfil> perfiles;

    public Usuario(@Valid UsuarioRegistroDTO datos) {
        this.nombre = datos.nombre();
        this.correoElectronico = datos.correoElectronico();
        this.contrasena = datos.contrasena();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfiles.stream()
                .map(p -> (GrantedAuthority) p)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correoElectronico;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void actualizarInformacion(Usuario datos) {
        if (datos.getNombre() != null) {
            this.nombre = datos.getNombre();
        }
        if (datos.getCorreoElectronico() != null) {
            this.correoElectronico = datos.getCorreoElectronico();
        }
        if (datos.getContrasena() != null) {
            this.contrasena = datos.getContrasena();
        }
    }

    public void actualizarInformacion(UsuarioRegistroDTO datos) {
        if(datos.nombre() != null){
            this.nombre = datos.nombre();
        }
        if(datos.correoElectronico() != null){
            this.correoElectronico = datos.correoElectronico();
        }
        if(datos.contrasena() != null){
            this.contrasena = datos.contrasena();
        }
    }
}
