package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.curso.CursoRepository;
import com.carlos.challenge_foro_hub.domain.topico.*;
import com.carlos.challenge_foro_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid TopicoRegistroDTO datos){
        var autor = usuarioRepository.getReferenceById(datos.autorId());
        var curso = cursoRepository.getReferenceById(datos.cursoId());

        repository.save(new Topico(datos, autor, curso));
    }

    @GetMapping
    public List<TopicoObtenerDTO> listar(){
        return repository.findAll().stream().map(TopicoObtenerDTO::new).toList();
    }

    @GetMapping("/{id}")
    public TopicoObtenerDTO detallar(@PathVariable Long id){
        return new TopicoObtenerDTO(repository.getReferenceById(id));
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody TopicoRegistroDTO datos){
        var topico = repository.getReferenceById(id);
        topico.actualizarInformacion(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        if(topico != null){
            repository.delete(topico);
        }
    }
}
