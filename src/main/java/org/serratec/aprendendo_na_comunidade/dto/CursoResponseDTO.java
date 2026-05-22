package org.serratec.aprendendo_na_comunidade.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de resposta dos cursos")
public class CursoResponseDTO {

    @Schema(
        description = "ID do curso",
        example = "1"
    )
    private Long id;

    @Schema(
        description = "Nome do curso",
        example = "Spring Boot"
    )
    private String nome;

    @Schema(
        description = "Carga horária do curso",
        example = "40"
    )
    private Integer cargaHoraria;

    @Schema(
        description = "Categoria associada ao curso"
    )
    private CategoriaCursoDTO categoria;

    @Schema(
        description = "Professor responsável pelo curso"
    )
    private ProfessorDTO professor;

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

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public CategoriaCursoDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCursoDTO categoria) {
        this.categoria = categoria;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }
}