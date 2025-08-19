package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.respuesta.Respuesta;
import com.carlos.challenge_foro_hub.domain.respuesta.RespuestaRepository;
import com.carlos.challenge_foro_hub.domain.topico.Topico;
import com.carlos.challenge_foro_hub.domain.topico.TopicoRepository;
import com.carlos.challenge_foro_hub.domain.usuario.Usuario;
import com.carlos.challenge_foro_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid Respuesta datos){
        Usuario autor = usuarioRepository.getReferenceById(datos.getAutor().getId());
        Topico topico = topicoRepository.getReferenceById(datos.getTopico().getId());
        repository.save(new Respuesta(null, datos.getMensaje(), topico, datos.getFechaCreacion(), autor, datos.getSolucion()));
    }

    @GetMapping
    public List<Respuesta> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Respuesta detallar(@PathVariable Long id){
        return repository.getReferenceById(id);
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody Respuesta datos){
        Respuesta respuesta = repository.getReferenceById(id);
        respuesta.actualizarInformacion(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        Respuesta respuesta = repository.getReferenceById(id);
        repository.delete(respuesta);
    }
}
