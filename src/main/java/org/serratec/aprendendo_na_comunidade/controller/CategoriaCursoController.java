package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;

import org.serratec.aprendendo_na_comunidade.dto.CategoriaCursoDTO;

import org.serratec.aprendendo_na_comunidade.service.CategoriaCursoService;

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
@RequestMapping("/categorias")

@Tag(
    name = "Categorias",
    description = "Endpoints responsáveis pelo gerenciamento das categorias dos cursos"
)

public class CategoriaCursoController {

    @Autowired
    private CategoriaCursoService service;

    @GetMapping

    @Operation(
        summary = "Listar categorias",
        description = "Retorna todas as categorias cadastradas"
    )

    public ResponseEntity<List<CategoriaCursoDTO>>
            listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos());
    }

    @GetMapping("/{id}")

    @Operation(
        summary = "Buscar categoria por ID",
        description = "Retorna uma categoria específica pelo ID"
    )

    public ResponseEntity<CategoriaCursoDTO>
            buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id));
    }

    @PostMapping

    @Operation(
        summary = "Cadastrar categoria",
        description = "Cadastra uma nova categoria no sistema"
    )

    public ResponseEntity<CategoriaCursoDTO>
            inserir(
            @Valid
            @RequestBody
            CategoriaCursoDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.inserir(dto));
    }

    @PutMapping("/{id}")

    @Operation(
        summary = "Atualizar categoria",
        description = "Atualiza os dados de uma categoria existente"
    )

    public ResponseEntity<CategoriaCursoDTO>
            atualizar(
            @PathVariable Long id,
            @Valid
            @RequestBody
            CategoriaCursoDTO dto) {

        return ResponseEntity.ok(
                service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")

    @Operation(
        summary = "Deletar categoria",
        description = "Remove uma categoria do sistema"
    )

    public ResponseEntity<Void>
            deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}