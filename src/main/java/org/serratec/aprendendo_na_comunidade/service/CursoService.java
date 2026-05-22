package org.serratec.aprendendo_na_comunidade.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.aprendendo_na_comunidade.domain.CategoriaCurso;
import org.serratec.aprendendo_na_comunidade.domain.Curso;
import org.serratec.aprendendo_na_comunidade.domain.Professor;

import org.serratec.aprendendo_na_comunidade.dto.CategoriaCursoDTO;
import org.serratec.aprendendo_na_comunidade.dto.CursoRequestDTO;
import org.serratec.aprendendo_na_comunidade.dto.CursoResponseDTO;
import org.serratec.aprendendo_na_comunidade.dto.ProfessorDTO;

import org.serratec.aprendendo_na_comunidade.exception.ResourceNotFoundException;

import org.serratec.aprendendo_na_comunidade.repository.CategoriaCursoRepository;
import org.serratec.aprendendo_na_comunidade.repository.CursoRepository;
import org.serratec.aprendendo_na_comunidade.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private CategoriaCursoRepository categoriaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<CursoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .collect(Collectors.toList());
    }

    public CursoResponseDTO buscarPorId(Long id) {

        Curso curso = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Curso não encontrado"));

        return converterParaResponseDTO(curso);
    }

    public CursoResponseDTO inserir(CursoRequestDTO dto) {

        CategoriaCurso categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria não encontrada"));

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Professor não encontrado"));

        Curso curso = new Curso();

        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());

        curso.setCategoria(categoria);
        curso.setProfessor(professor);

        curso = repository.save(curso);

        return converterParaResponseDTO(curso);
    }

    public CursoResponseDTO atualizar(Long id, CursoRequestDTO dto) {

        Curso curso = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Curso não encontrado"));

        CategoriaCurso categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoria não encontrada"));

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Professor não encontrado"));

        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());

        curso.setCategoria(categoria);
        curso.setProfessor(professor);

        curso = repository.save(curso);

        return converterParaResponseDTO(curso);
    }

    public void deletar(Long id) {

        Curso curso = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Curso não encontrado"));

        repository.delete(curso);
    }

    private CursoResponseDTO converterParaResponseDTO(Curso curso) {

        CursoResponseDTO dto = new CursoResponseDTO();

        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setCargaHoraria(curso.getCargaHoraria());

        if (curso.getCategoria() != null) {

            CategoriaCursoDTO categoriaDTO = new CategoriaCursoDTO();

            categoriaDTO.setId(curso.getCategoria().getId());
            categoriaDTO.setNome(curso.getCategoria().getNome());

            dto.setCategoria(categoriaDTO);
        }

        if (curso.getProfessor() != null) {

            ProfessorDTO professorDTO = new ProfessorDTO();

            professorDTO.setId(curso.getProfessor().getId());
            professorDTO.setNome(curso.getProfessor().getNome());

            dto.setProfessor(professorDTO);
        }

        return dto;
    }
}