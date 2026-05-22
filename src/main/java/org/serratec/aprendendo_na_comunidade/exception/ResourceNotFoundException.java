package org.serratec.aprendendo_na_comunidade.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}