package com.example.exerciseCeiba.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Rol")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Nombre", length = 50)
    private String nombre;
}
