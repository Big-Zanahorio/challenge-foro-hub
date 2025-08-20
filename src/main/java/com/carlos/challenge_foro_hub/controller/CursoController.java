package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.curso.Curso;
import com.carlos.challenge_foro_hub.domain.curso.CursoObtenerDTO;
import com.carlos.challenge_foro_hub.domain.curso.CursoRegistroDTO;
import com.carlos.challenge_foro_hub.domain.curso.CursoRepository;
import com.carlos.challenge_foro_hub.domain.topico.TopicoObtenerDTO;
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
    public void registrar(@RequestBody @Valid CursoRegistroDTO datos){
        repository.save(new Curso(datos));
    }

    @GetMapping
    public List<CursoObtenerDTO> listar(){
        return repository.findAll().stream().map(CursoObtenerDTO::new).toList();
    }

    @GetMapping("/{id}")
    public CursoObtenerDTO detallar(@PathVariable Long id){
        return new CursoObtenerDTO(repository.getReferenceById(id));
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody CursoRegistroDTO datos){
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
