package org.serratec.aprendendo_na_comunidade.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.aprendendo_na_comunidade.domain.CategoriaCurso;

import org.serratec.aprendendo_na_comunidade.dto.CategoriaCursoDTO;

import org.serratec.aprendendo_na_comunidade.exception.ResourceNotFoundException;

import org.serratec.aprendendo_na_comunidade.repository.CategoriaCursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaCursoService {

    @Autowired
    private CategoriaCursoRepository repository;

    public List<CategoriaCursoDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public CategoriaCursoDTO buscarPorId(Long id) {

        CategoriaCurso categoria = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria não encontrada"));

        return converterParaDTO(categoria);
    }

    public CategoriaCursoDTO inserir(CategoriaCursoDTO dto) {

        CategoriaCurso categoria = new CategoriaCurso();

        categoria.setNome(dto.getNome());

        categoria = repository.save(categoria);

        return converterParaDTO(categoria);
    }

    public CategoriaCursoDTO atualizar(
            Long id,
            CategoriaCursoDTO dto) {

        CategoriaCurso categoria = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria não encontrada"));

        categoria.setNome(dto.getNome());

        categoria = repository.save(categoria);

        return converterParaDTO(categoria);
    }

    public void deletar(Long id) {

        CategoriaCurso categoria = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria não encontrada"));

        repository.delete(categoria);
    }

    private CategoriaCursoDTO converterParaDTO(
            CategoriaCurso categoria) {

        CategoriaCursoDTO dto = new CategoriaCursoDTO();

        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());

        return dto;
    }
}