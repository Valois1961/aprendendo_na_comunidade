package org.serratec.aprendendo_na_comunidade.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "DTO utilizado para cadastro e atualização de cursos")
public class CursoRequestDTO {

    @Schema(
        description = "Nome do curso",
        example = "Spring Boot"
    )

    @NotBlank(message = "O nome do curso é obrigatório")
    private String nome;

    @Schema(
        description = "Carga horária do curso",
        example = "40"
    )

    @NotNull(message = "A carga horária é obrigatória")
    @Positive(message = "A carga horária deve ser maior que zero")
    private Integer cargaHoraria;

    @Schema(
        description = "ID da categoria do curso",
        example = "1"
    )

    @NotNull(message = "A categoria é obrigatória")
    private Long categoriaId;

    @Schema(
        description = "ID do professor responsável pelo curso",
        example = "1"
    )

    @NotNull(message = "O professor é obrigatório")
    private Long professorId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }
}