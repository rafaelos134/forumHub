package com.alura.forumHub.controler;

import com.alura.forumHub.model.Topico;
import com.alura.forumHub.repository.TopicoRepository;
import com.alura.forumHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {


    //    @Autowired
    private TopicoRepository topicoRepository;
    private TopicoService topicoService;

    public TopicoController(TopicoRepository topicoRepository, TopicoService topicoService) {
        this.topicoRepository = topicoRepository;
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<Topico> cadastrarTopico(@RequestBody @Valid Topico topico) {
        Topico savedTopico = topicoService.cadastrarTopico(topico);
        return ResponseEntity.ok(savedTopico);
    }

    // Listagem simples de todos os tópicos
    @GetMapping
    public ResponseEntity<List<Topico>> listarTodos() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    // Listagem paginada com ordenação
    @GetMapping("/paginado")
    public ResponseEntity<Page<Topico>> listarPaginado(
            @PageableDefault(size = 10, sort = "ano", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Topico> topicos = topicoRepository.findAll(pageable);
        return ResponseEntity.ok(topicos);
    }

    // Listagem por nome de curso e ano
    @GetMapping("/buscar")
    public ResponseEntity<List<Topico>> listarPorCursoEAno(@RequestParam String curso, @RequestParam int ano) {
        List<Topico> topicos = topicoRepository.findByCursoAndAno(curso, ano);
        return ResponseEntity.ok(topicos);
    }

    // Detalhamento de um tópico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalharTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTopico(@PathVariable Long id) {
        if (topicoRepository.findById(id).isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizarTopico(@PathVariable Long id, @RequestBody Topico topicoAtualizado) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            Topico topico = topicoOptional.get();
            topico.setTitulo(topicoAtualizado.getTitulo());
            topico.setMensagem(topicoAtualizado.getMensagem());
            topico.setAutor(topicoAtualizado.getAutor());
            topico.setCurso(topicoAtualizado.getCurso());
            topicoRepository.save(topico);
            return ResponseEntity.ok(topico);
        }
        return ResponseEntity.notFound().build();
    }
}
