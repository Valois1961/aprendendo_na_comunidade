package org.serratec.aprendendo_na_comunidade.controller;
import java.util.List;
import org.serratec.aprendendo_na_comunidade.dto.ProfessorDTO;
import org.serratec.aprendendo_na_comunidade.service.ProfessorService;
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
@RestController @RequestMapping("/professores")
@Tag(name = "Professores", description = "Endpoints responsáveis pelo gerenciamento de professores")
public class ProfessorController {
@Autowired
private ProfessorService service;

@GetMapping

@Operation(
    summary = "Listar professores",
    description = "Retorna todos os professores cadastrados"
)

public ResponseEntity<List<ProfessorDTO>>
        listarTodos() {

    return ResponseEntity.ok(
            service.listarTodos());
}

@GetMapping("/{id}")

@Operation(
    summary = "Buscar professor por ID",
    description = "Retorna um professor específico pelo ID"
)

public ResponseEntity<ProfessorDTO>
        buscarPorId(@PathVariable Long id) {

    return ResponseEntity.ok(
            service.buscarPorId(id));
}

@PostMapping

@Operation(
    summary = "Cadastrar professor",
    description = "Cadastra um novo professor no sistema"
)

public ResponseEntity<ProfessorDTO>
        inserir(
        @Valid
        @RequestBody
        ProfessorDTO dto) {

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.inserir(dto));
}
}
