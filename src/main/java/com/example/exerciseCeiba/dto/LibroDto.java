package com.example.exerciseCeiba.dto;

import javax.validation.constraints.NotNull;

public class LibroDto {

    @NotNull
    private String isbn;

    @NotNull
    private String nombre;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
