package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.topico.Topico;
import com.carlos.challenge_foro_hub.domain.topico.TopicoObtenerDTO;
import com.carlos.challenge_foro_hub.domain.topico.TopicoRegistroDTO;
import com.carlos.challenge_foro_hub.domain.topico.TopicoRepository;
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
    public List<TopicoObtenerDTO> mostrar(){
        return repository.findAll().stream().map(TopicoObtenerDTO::new).toList();
    }
}
