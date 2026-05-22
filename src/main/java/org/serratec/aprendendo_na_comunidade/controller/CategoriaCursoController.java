package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aprendendo_na_comunidade.domain.CategoriaCurso;
import org.serratec.aprendendo_na_comunidade.repository.CategoriaCursoRepository;
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
@RequestMapping("/categorias")
public class CategoriaCursoController {

	@Autowired
	private CategoriaCursoRepository repository;

	@GetMapping
	public List<CategoriaCurso> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<CategoriaCurso> buscar(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PostMapping
	public CategoriaCurso inserir(@RequestBody CategoriaCurso categoria) {
		return repository.save(categoria);
	}

	@PutMapping("/{id}")
	public CategoriaCurso atualizar(@PathVariable Long id, @RequestBody CategoriaCurso categoria) {

		CategoriaCurso categoriaBanco = repository.findById(id).orElse(null);

		if (categoriaBanco != null) {
			categoriaBanco.setNome(categoria.getNome());

			return repository.save(categoriaBanco);
		}

		return null;
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
}