package com.example.exerciseCeiba.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IsbnPalindromoException extends RuntimeException {
    public IsbnPalindromoException() {
    }

    public IsbnPalindromoException(String message) {
        super(message);
    }
}
