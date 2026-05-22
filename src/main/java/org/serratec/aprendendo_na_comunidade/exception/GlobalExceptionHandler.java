package org.serratec.aprendendo_na_comunidade.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.serratec.aprendendo_na_comunidade.dto.ErroRespostaDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroRespostaDTO>
            tratarRecursoNaoEncontrado(
            ResourceNotFoundException ex) {

        ErroRespostaDTO erro =
                new ErroRespostaDTO();

        erro.setStatus(HttpStatus.NOT_FOUND.value());

        erro.setErro("Recurso não encontrado");

        erro.setMensagem(ex.getMessage());

        erro.setDataHora(LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO>
            tratarValidacoes(
            MethodArgumentNotValidException ex) {

        Map<String, String> erros =
                new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(erro ->
                        erros.put(
                                erro.getField(),
                                erro.getDefaultMessage()));

        ErroRespostaDTO resposta =
                new ErroRespostaDTO();

        resposta.setStatus(
                HttpStatus.BAD_REQUEST.value());

        resposta.setErro(
                "Erro de validação");

        resposta.setMensagem(
                "Existem campos inválidos");

        resposta.setDataHora(
                LocalDateTime.now());

        resposta.setErros(erros);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }
}