package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.dto.PersonaDto;
import com.example.exerciseCeiba.entidades.Persona;
//import sun.security.provider.certpath.OCSPResponse;

import java.util.List;

public interface PersonaServicio {

    PersonaDto agregarPersona(PersonaDto personaDto);

    List<Persona> consultarPersonas();

    void borrarPersona(int id);
}
