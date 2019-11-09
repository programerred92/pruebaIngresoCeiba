package com.example.exerciseCeiba.repositorios;

import com.example.exerciseCeiba.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

}
