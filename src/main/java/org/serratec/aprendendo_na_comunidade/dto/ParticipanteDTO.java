package org.serratec.aprendendo_na_comunidade.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO de participantes")
public class ParticipanteDTO {

    @Schema(
        description = "ID do participante",
        example = "1"
    )
    private Long id;

    @Schema(
        description = "Nome do participante",
        example = "João Silva"
    )

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100,
          message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Schema(
        description = "Email do participante",
        example = "joao@email.com"
    )

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Schema(
        description = "Perfil social do participante",
        example = "@joaosilva"
    )
    private String perfilSocial;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfilSocial() {
        return perfilSocial;
    }

    public void setPerfilSocial(String perfilSocial) {
        this.perfilSocial = perfilSocial;
    }
}