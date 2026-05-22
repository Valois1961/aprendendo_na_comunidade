package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.aprendendo_na_comunidade.domain.Participante;
import org.serratec.aprendendo_na_comunidade.dto.ParticipanteDTO;
import org.serratec.aprendendo_na_comunidade.repository.ParticipanteRepository;
import org.serratec.aprendendo_na_comunidade.service.ParticipanteService;

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
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteRepository repository;

    @Autowired
    private ParticipanteService service;

    @GetMapping
    public List<ParticipanteDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Participante> buscar(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Participante inserir(@RequestBody Participante participante) {
        return repository.save(participante);
    }

    @PutMapping("/{id}")
    public Participante atualizar(@PathVariable Long id,
                                  @RequestBody Participante participante) {

        Participante participanteBanco =
                repository.findById(id).orElse(null);

        if (participanteBanco != null) {

            participanteBanco.setNome(participante.getNome());
            participanteBanco.setEmail(participante.getEmail());
            participanteBanco.setPerfisSociais(
                    participante.getPerfisSociais());

            return repository.save(participanteBanco);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}