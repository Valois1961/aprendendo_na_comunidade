package org.serratec.aprendendo_na_comunidade.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO utilizado para cadastro de matrículas")
public class MatriculaRequestDTO {

    @Schema(
        description = "Data da matrícula",
        example = "2026-05-21"
    )

    @NotNull(message = "A data da matrícula é obrigatória")
    private LocalDate dataMatricula;

    @Schema(
        description = "ID do participante",
        example = "1"
    )

    @NotNull(message = "O participante é obrigatório")
    private Long participanteId;

    @Schema(
        description = "ID do curso",
        example = "1"
    )

    @NotNull(message = "O curso é obrigatório")
    private Long cursoId;

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}