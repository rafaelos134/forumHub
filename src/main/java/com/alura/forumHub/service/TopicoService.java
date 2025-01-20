package com.alura.forumHub.service;

import com.alura.forumHub.model.Topico;
import com.alura.forumHub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
@Validated
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico cadastrarTopico(@Valid Topico topico) {
        if (topicoRepository.findByTituloAndMensagem(topico.getTitulo(), topico.getMensagem()).isPresent()) {
            throw new IllegalArgumentException("Tópico duplicado: título e mensagem já existem.");
        }
        return topicoRepository.save(topico);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Topico>> listarPorCursoEAno(@RequestParam String curso, @RequestParam int ano) {
        List<Topico> topicos = topicoRepository.findByCursoAndAno(curso, ano);
        return ResponseEntity.ok(topicos);
    }
}
