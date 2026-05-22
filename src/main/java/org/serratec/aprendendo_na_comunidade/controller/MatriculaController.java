package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;

import org.serratec.aprendendo_na_comunidade.dto.MatriculaRequestDTO;
import org.serratec.aprendendo_na_comunidade.dto.MatriculaResponseDTO;

import org.serratec.aprendendo_na_comunidade.service.MatriculaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/matriculas")

@Tag(
    name = "Matrículas",
    description = "Endpoints responsáveis pelo gerenciamento das matrículas dos participantes"
)

public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @GetMapping

    @Operation(
        summary = "Listar matrículas",
        description = "Retorna todas as matrículas cadastradas"
    )

    public ResponseEntity<List<MatriculaResponseDTO>>
            listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos());
    }

    @GetMapping("/{id}")

    @Operation(
        summary = "Buscar matrícula por ID",
        description = "Retorna uma matrícula específica pelo ID"
    )

    public ResponseEntity<MatriculaResponseDTO>
            buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id));
    }

    @PostMapping

    @Operation(
        summary = "Cadastrar matrícula",
        description = "Realiza uma nova matrícula de participante em curso"
    )

    public ResponseEntity<MatriculaResponseDTO>
            inserir(
            @Valid
            @RequestBody
            MatriculaRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.inserir(dto));
    }

    @DeleteMapping("/{id}")

    @Operation(
        summary = "Deletar matrícula",
        description = "Remove uma matrícula do sistema"
    )

    public ResponseEntity<Void>
            deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}