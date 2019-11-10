package com.example.exerciseCeiba.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cantidadPrestada")
    private int cantidadPrestada;
    @Column(name = "cantidadDisponible")
    private int cantidadDisponible;

}
