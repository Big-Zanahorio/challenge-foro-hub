package com.carlos.challenge_foro_hub.controller;

import com.carlos.challenge_foro_hub.domain.respuesta.Respuesta;
import com.carlos.challenge_foro_hub.domain.respuesta.RespuestaObtenerDTO;
import com.carlos.challenge_foro_hub.domain.respuesta.RespuestaRegistroDTO;
import com.carlos.challenge_foro_hub.domain.respuesta.RespuestaRepository;
import com.carlos.challenge_foro_hub.domain.topico.Topico;
import com.carlos.challenge_foro_hub.domain.topico.TopicoObtenerDTO;
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
    public void registrar(@RequestBody @Valid RespuestaRegistroDTO datos){
        Usuario autor = usuarioRepository.getReferenceById(datos.autorId());
        Topico topico = topicoRepository.getReferenceById(datos.topicoId());
        repository.save(new Respuesta(
                datos,
                topicoRepository.getReferenceById(datos.topicoId()),
                usuarioRepository.getReferenceById(datos.autorId())
                ));
    }

    @GetMapping
    public List<RespuestaObtenerDTO> listar(){
        return repository.findAll().stream().map(RespuestaObtenerDTO::new).toList();
    }

    @GetMapping("/{id}")
    public RespuestaObtenerDTO detallar(@PathVariable Long id){
        return new RespuestaObtenerDTO(repository.getReferenceById(id));
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@PathVariable Long id, @RequestBody RespuestaRegistroDTO datos){
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
