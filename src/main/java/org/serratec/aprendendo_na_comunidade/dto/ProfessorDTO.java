package org.serratec.aprendendo_na_comunidade.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProfessorDTO {

    private Long id;

    @NotBlank(message = "O nome do professor é obrigatório")
    @Size(min = 3, max = 100,
          message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}