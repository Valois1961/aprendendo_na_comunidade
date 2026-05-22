package org.serratec.aprendendo_na_comunidade.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.aprendendo_na_comunidade.domain.Curso;
import org.serratec.aprendendo_na_comunidade.domain.Matricula;
import org.serratec.aprendendo_na_comunidade.domain.Participante;
import org.serratec.aprendendo_na_comunidade.domain.PerfilSocial;

import org.serratec.aprendendo_na_comunidade.dto.CategoriaCursoDTO;
import org.serratec.aprendendo_na_comunidade.dto.CursoResponseDTO;
import org.serratec.aprendendo_na_comunidade.dto.MatriculaRequestDTO;
import org.serratec.aprendendo_na_comunidade.dto.MatriculaResponseDTO;
import org.serratec.aprendendo_na_comunidade.dto.ParticipanteDTO;
import org.serratec.aprendendo_na_comunidade.dto.ProfessorDTO;

import org.serratec.aprendendo_na_comunidade.exception.ResourceNotFoundException;

import org.serratec.aprendendo_na_comunidade.repository.CursoRepository;
import org.serratec.aprendendo_na_comunidade.repository.MatriculaRepository;
import org.serratec.aprendendo_na_comunidade.repository.ParticipanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<MatriculaResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public MatriculaResponseDTO buscarPorId(Long id) {

        Matricula matricula = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Matrícula não encontrada"));

        return converterParaDTO(matricula);
    }

    public MatriculaResponseDTO inserir(
            MatriculaRequestDTO dto) {

        Participante participante =
                participanteRepository.findById(dto.getParticipanteId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Participante não encontrado"));

        Curso curso =
                cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Curso não encontrado"));

        Matricula matricula = new Matricula();

        matricula.setDataMatricula(dto.getDataMatricula());

        matricula.setParticipante(participante);

        matricula.setCurso(curso);

        matricula = repository.save(matricula);

        return converterParaDTO(matricula);
    }

    public void deletar(Long id) {

        Matricula matricula = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Matrícula não encontrada"));

        repository.delete(matricula);
    }

    private MatriculaResponseDTO converterParaDTO(
            Matricula matricula) {

        MatriculaResponseDTO dto =
                new MatriculaResponseDTO();

        dto.setId(matricula.getId());

        dto.setDataMatricula(
                matricula.getDataMatricula());

        ParticipanteDTO participanteDTO =
                new ParticipanteDTO();

        participanteDTO.setId(
                matricula.getParticipante().getId());

        participanteDTO.setNome(
                matricula.getParticipante().getNome());

        participanteDTO.setEmail(
                matricula.getParticipante().getEmail());

        if (matricula.getParticipante().getPerfisSociais() != null
                && !matricula.getParticipante().getPerfisSociais().isEmpty()) {

            PerfilSocial perfil =
                    matricula.getParticipante()
                    .getPerfisSociais()
                    .get(0);

            participanteDTO.setPerfilSocial(
                    perfil.getDescricao());
        }

        dto.setParticipante(participanteDTO);

        CursoResponseDTO cursoDTO =
                new CursoResponseDTO();

        cursoDTO.setId(
                matricula.getCurso().getId());

        cursoDTO.setNome(
                matricula.getCurso().getNome());

        cursoDTO.setCargaHoraria(
                matricula.getCurso().getCargaHoraria());

        if (matricula.getCurso().getCategoria() != null) {

            CategoriaCursoDTO categoriaDTO =
                    new CategoriaCursoDTO();

            categoriaDTO.setId(
                    matricula.getCurso()
                    .getCategoria()
                    .getId());

            categoriaDTO.setNome(
                    matricula.getCurso()
                    .getCategoria()
                    .getNome());

            cursoDTO.setCategoria(categoriaDTO);
        }

        if (matricula.getCurso().getProfessor() != null) {

            ProfessorDTO professorDTO =
                    new ProfessorDTO();

            professorDTO.setId(
                    matricula.getCurso()
                    .getProfessor()
                    .getId());

            professorDTO.setNome(
                    matricula.getCurso()
                    .getProfessor()
                    .getNome());

            cursoDTO.setProfessor(professorDTO);
        }

        dto.setCurso(cursoDTO);

        return dto;
    }
}