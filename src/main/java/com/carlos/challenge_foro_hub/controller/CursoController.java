package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.curso.Curso;
import com.carlos.challenge_foro_hub.domain.curso.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid Curso curso){
        repository.save(curso);
    }

    @GetMapping
    public List<Curso> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Curso detallar(@PathVariable Long id){
        return repository.getReferenceById(id);
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody Curso datos){
        Curso curso = repository.getReferenceById(id);
        curso.actualizarInformacion(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        Curso curso = repository.getReferenceById(id);
        repository.delete(curso);
    }
}
