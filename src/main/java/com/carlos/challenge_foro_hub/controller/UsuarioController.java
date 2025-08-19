package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.usuario.Usuario;
import com.carlos.challenge_foro_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid Usuario usuario){
        repository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario detallar(@PathVariable Long id){
        return repository.getReferenceById(id);
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody Usuario datos){
        Usuario usuario = repository.getReferenceById(id);
        usuario.actualizarInformacion(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        Usuario usuario = repository.getReferenceById(id);
        repository.delete(usuario);
    }
}
