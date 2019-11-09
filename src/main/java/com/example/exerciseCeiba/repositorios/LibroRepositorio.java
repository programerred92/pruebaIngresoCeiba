package com.example.exerciseCeiba.repositorios;

import com.example.exerciseCeiba.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio  extends JpaRepository <Libro, String> {
}
