package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aprendendo_na_comunidade.domain.Professor;
import org.serratec.aprendendo_na_comunidade.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository repository;

	@GetMapping
	public List<Professor> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Professor> buscar(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PostMapping
	public Professor inserir(@RequestBody Professor professor) {
		return repository.save(professor);
	}

	@PutMapping("/{id}")
	public Professor atualizar(@PathVariable Long id, @RequestBody Professor professor) {
		professor.setId(id);
		return repository.save(professor);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
}