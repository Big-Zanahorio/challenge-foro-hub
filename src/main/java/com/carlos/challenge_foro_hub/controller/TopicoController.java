package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.topico.Topico;
import com.carlos.challenge_foro_hub.domain.topico.TopicoRegistroDTO;
import com.carlos.challenge_foro_hub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void registrar(@RequestBody TopicoRegistroDTO datos){
        repository.save(new Topico(datos));
    }
}
