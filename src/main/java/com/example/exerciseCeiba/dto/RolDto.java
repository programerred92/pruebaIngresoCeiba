package com.example.exerciseCeiba.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class RolDto {
    @NotNull
    private int id;
    @NotNull
    private String nombre;
}
