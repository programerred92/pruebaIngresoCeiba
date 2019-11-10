package com.example.exerciseCeiba.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Stock")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;

    @Column(name = "cantidadPrestada")
    private int cantidadPrestada;

    @Column(name = "cantidadDisponible")
    private int cantidadDisponible;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prestamoId")
    private List<Prestamo> prestamos = new ArrayList<>();

}
