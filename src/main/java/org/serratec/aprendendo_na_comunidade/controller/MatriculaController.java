package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;

import org.serratec.aprendendo_na_comunidade.domain.Matricula;
import org.serratec.aprendendo_na_comunidade.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

    @GetMapping("/matriculas")
    public List<Matricula> listar() {
        return repository.findAll();
    }

    @PostMapping("/matriculas")
    public Matricula inserir(@RequestBody Matricula matricula) {
        return repository.save(matricula);
    }
}