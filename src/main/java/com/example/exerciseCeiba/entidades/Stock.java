package com.example.exerciseCeiba.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "libros_stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cantidadPrestada")
    private int cantidadPrestada;
    @Column(name = "cantidadDisponible")
    private int cantidadDisponible;
    @Column(name = "isbn")
    private String isbn;
}
