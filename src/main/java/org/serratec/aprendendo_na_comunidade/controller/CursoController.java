package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aprendendo_na_comunidade.domain.Curso;
import org.serratec.aprendendo_na_comunidade.repository.CursoRepository;
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
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository repository;

	@GetMapping
	public List<Curso> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Curso> buscar(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PostMapping
	public Curso inserir(@RequestBody Curso curso) {
		return repository.save(curso);
	}
	@PutMapping("/{id}")
	public Curso atualizar(@PathVariable Long id, @RequestBody Curso curso) {

		Curso cursoBanco = repository.findById(id).orElse(null);

		if (cursoBanco != null) {
			cursoBanco.setNome(curso.getNome());
			cursoBanco.setCargaHoraria(curso.getCargaHoraria());
			cursoBanco.setCategoria(curso.getCategoria());
			cursoBanco.setProfessor(curso.getProfessor());

			return repository.save(cursoBanco);
		}

		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
}