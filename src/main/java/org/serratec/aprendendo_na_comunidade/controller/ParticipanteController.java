package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;

import org.serratec.aprendendo_na_comunidade.domain.Participante;

import org.serratec.aprendendo_na_comunidade.dto.ParticipanteDTO;

import org.serratec.aprendendo_na_comunidade.service.ParticipanteService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService service;

    @GetMapping
    public ResponseEntity<List<ParticipanteDTO>>
            listarTodos() {

        return ResponseEntity.ok(
                service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteDTO>
            buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ParticipanteDTO>
            inserir(
            @Valid
            @RequestBody
            Participante participante) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.inserir(participante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteDTO>
            atualizar(
            @PathVariable Long id,
            @Valid
            @RequestBody
            Participante participante) {

        return ResponseEntity.ok(
                service.atualizar(id, participante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
            deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}