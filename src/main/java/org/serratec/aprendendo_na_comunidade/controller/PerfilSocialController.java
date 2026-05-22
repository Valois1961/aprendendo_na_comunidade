package org.serratec.aprendendo_na_comunidade.controller;

import java.util.List;

import org.serratec.aprendendo_na_comunidade.domain.PerfilSocial;
import org.serratec.aprendendo_na_comunidade.repository.PerfilSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilSocialController {

    @Autowired
    private PerfilSocialRepository repository;

    @GetMapping("/perfis")
    public List<PerfilSocial> listar() {
        return repository.findAll();
    }

    @PostMapping("/perfis")
    public PerfilSocial inserir(@RequestBody PerfilSocial perfil) {
        return repository.save(perfil);
    }
}