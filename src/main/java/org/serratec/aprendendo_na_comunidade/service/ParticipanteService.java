package org.serratec.aprendendo_na_comunidade.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aprendendo_na_comunidade.domain.Participante;
import org.serratec.aprendendo_na_comunidade.domain.PerfilSocial;
import org.serratec.aprendendo_na_comunidade.dto.ParticipanteDTO;
import org.serratec.aprendendo_na_comunidade.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository repository;

    public List<ParticipanteDTO> listar() {

        List<Participante> participantes = repository.findAll();

        List<ParticipanteDTO> dtos = new ArrayList<>();

        for (Participante participante : participantes) {

            ParticipanteDTO dto = new ParticipanteDTO();

            dto.setId(participante.getId());
            dto.setNome(participante.getNome());
            dto.setEmail(participante.getEmail());

            if (participante.getPerfisSociais() != null &&
                !participante.getPerfisSociais().isEmpty()) {

                PerfilSocial perfil =
                        participante.getPerfisSociais().get(0);

                dto.setPerfilSocial(perfil.getDescricao());
            }

            dtos.add(dto);
        }

        return dtos;
    }

    public ParticipanteDTO buscarPorId(Long id) {

        Participante participante =
                repository.findById(id).orElseThrow();

        ParticipanteDTO dto = new ParticipanteDTO();

        dto.setId(participante.getId());
        dto.setNome(participante.getNome());
        dto.setEmail(participante.getEmail());

        return dto;
    }

    public ParticipanteDTO inserir(
            Participante participante) {

        participante = repository.save(participante);

        ParticipanteDTO dto = new ParticipanteDTO();

        dto.setId(participante.getId());
        dto.setNome(participante.getNome());
        dto.setEmail(participante.getEmail());

        return dto;
    }

    public ParticipanteDTO atualizar(
            Long id,
            Participante participante) {

        Participante participanteBanco =
                repository.findById(id).orElseThrow();

        participanteBanco.setNome(participante.getNome());
        participanteBanco.setEmail(participante.getEmail());

        participanteBanco =
                repository.save(participanteBanco);

        ParticipanteDTO dto = new ParticipanteDTO();

        dto.setId(participanteBanco.getId());
        dto.setNome(participanteBanco.getNome());
        dto.setEmail(participanteBanco.getEmail());

        return dto;
    }

    public void deletar(Long id) {

        repository.deleteById(id);
    }
}