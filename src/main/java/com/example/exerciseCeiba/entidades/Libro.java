package com.example.exerciseCeiba.entidades;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Libro")
@Data
@Builder
public class Libro {

    @Id
    @Column (name = "Isbn")
    private String isbn;

    @Column(name = "Nombre")
    private String nombre;

}
