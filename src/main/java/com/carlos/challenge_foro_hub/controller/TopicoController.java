package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.topico.*;
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

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid TopicoRegistroDTO datos){
        repository.save(new Topico(datos));
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
}
