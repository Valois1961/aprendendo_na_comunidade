package org.serratec.aprendendo_na_comunidade.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aprendendo_na_comunidade.domain.Professor;
import org.serratec.aprendendo_na_comunidade.dto.ProfessorDTO;
import org.serratec.aprendendo_na_comunidade.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<ProfessorDTO> listarTodos() {

        List<Professor> professores =
                repository.findAll();

        List<ProfessorDTO> dtos =
                new ArrayList<>();

        for (Professor professor : professores) {

            ProfessorDTO dto = new ProfessorDTO();

            dto.setId(professor.getId());
            dto.setNome(professor.getNome());

            dtos.add(dto);
        }

        return dtos;
    }

    public ProfessorDTO buscarPorId(Long id) {

        Professor professor =
                repository.findById(id).orElseThrow();

        ProfessorDTO dto = new ProfessorDTO();

        dto.setId(professor.getId());
        dto.setNome(professor.getNome());

        return dto;
    }

    public ProfessorDTO inserir(ProfessorDTO dto) {

        Professor professor = new Professor();

        professor.setNome(dto.getNome());

        professor = repository.save(professor);

        dto.setId(professor.getId());

        return dto;
    }

    public ProfessorDTO atualizar(
            Long id,
            ProfessorDTO dto) {

        Professor professor =
                repository.findById(id).orElseThrow();

        professor.setNome(dto.getNome());

        professor = repository.save(professor);

        ProfessorDTO resposta =
                new ProfessorDTO();

        resposta.setId(professor.getId());
        resposta.setNome(professor.getNome());

        return resposta;
    }

    public void deletar(Long id) {

        repository.deleteById(id);
    }
}