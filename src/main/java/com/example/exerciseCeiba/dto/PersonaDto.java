package com.example.exerciseCeiba.dto;

import com.example.exerciseCeiba.entidades.Rol;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
public class PersonaDto {

    private int id;
    @NotNull
    private String nombreCompleto;
    @NotNull
    private String user;
    @NotNull
    private String password;
    private Rol rol;
}
