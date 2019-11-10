package com.example.exerciseCeiba.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistroNoEncontradoException extends RuntimeException {
    public RegistroNoEncontradoException() {
    }

    public RegistroNoEncontradoException(String message) {
        super(message);
    }
}
