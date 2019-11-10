package com.example.exerciseCeiba.dto;

import com.example.exerciseCeiba.entidades.Libro;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class StockDto {
    @NotNull
    private int id;
    @NotNull
    private int cantidadPrestada;
    @NotNull
    private int cantidadDisponible;
    private Libro libro;

}
