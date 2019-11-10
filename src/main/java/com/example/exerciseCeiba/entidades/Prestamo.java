package com.example.exerciseCeiba.entidades;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
@Data
public class Prestamo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name ="fechaDePrestamo")
    private LocalDate fechaDePrestamo;

    @Column(name ="fechaDeEntrega")
    private LocalDate fechaDeEntrega;

    @Column(name = "prestador")
    private String prestador;

}
