package com.example.exerciseCeiba.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Persona")
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", length = 150)
    private String nombreCompleto;
    @Column(name = "user", length = 50)
    private String user;
    @Column(name = "pass", length = 50)
    private String pass;
    /*@Transient
    private int id_rol;*/
}
