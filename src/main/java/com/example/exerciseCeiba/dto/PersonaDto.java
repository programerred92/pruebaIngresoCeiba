package com.example.exerciseCeiba.dto;

import javax.validation.constraints.NotNull;

public class PersonaDto {

    private int id;
    @NotNull
    private String nombreCompleto;
    @NotNull
    private String user;
    @NotNull
    private String password;

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }
}
