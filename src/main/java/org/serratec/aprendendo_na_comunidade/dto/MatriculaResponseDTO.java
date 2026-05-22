package org.serratec.aprendendo_na_comunidade.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de resposta das matrículas")
public class MatriculaResponseDTO {

    @Schema(
        description = "ID da matrícula",
        example = "1"
    )
    private Long id;

    @Schema(
        description = "Data da matrícula",
        example = "2026-05-21"
    )
    private LocalDate dataMatricula;

    @Schema(
        description = "Participante matriculado"
    )
    private ParticipanteDTO participante;

    @Schema(
        description = "Curso relacionado à matrícula"
    )
    private CursoResponseDTO curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public ParticipanteDTO getParticipante() {
        return participante;
    }

    public void setParticipante(ParticipanteDTO participante) {
        this.participante = participante;
    }

    public CursoResponseDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoResponseDTO curso) {
        this.curso = curso;
    }
}