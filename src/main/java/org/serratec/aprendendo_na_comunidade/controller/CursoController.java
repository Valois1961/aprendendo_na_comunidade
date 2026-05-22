package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;

import org.serratec.aprendendo_na_comunidade.dto.CursoRequestDTO;
import org.serratec.aprendendo_na_comunidade.dto.CursoResponseDTO;

import org.serratec.aprendendo_na_comunidade.service.CursoService;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cursos")

@Tag(
    name = "Cursos",
    description = "Endpoints responsáveis pelo gerenciamento de cursos"
)

public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping

    @Operation(
        summary = "Listar cursos",
        description = "Retorna todos os cursos cadastrados"
    )

    public ResponseEntity<List<CursoResponseDTO>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")

    @Operation(
        summary = "Buscar curso por ID",
        description = "Retorna um curso específico pelo ID"
    )

    public ResponseEntity<CursoResponseDTO> buscar(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping

    @Operation(
        summary = "Cadastrar curso",
        description = "Cadastra um novo curso no sistema"
    )

    public ResponseEntity<CursoResponseDTO> inserir(
            @Valid @RequestBody CursoRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.inserir(dto));
    }

    @PutMapping("/{id}")

    @Operation(
        summary = "Atualizar curso",
        description = "Atualiza os dados de um curso existente"
    )

    public ResponseEntity<CursoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody CursoRequestDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")

    @Operation(
        summary = "Deletar curso",
        description = "Remove um curso do sistema"
    )

    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}