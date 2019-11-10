package com.example.exerciseCeiba.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class LibroDto {

    @NotNull
    private String isbn;

    @NotNull
    private String nombre;

}
