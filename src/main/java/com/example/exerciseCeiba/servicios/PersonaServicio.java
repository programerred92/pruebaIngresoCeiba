package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.dto.PersonaDto;
import com.example.exerciseCeiba.entidades.Persona;

import java.util.List;

//import sun.security.provider.certpath.OCSPResponse;

public interface PersonaServicio {

    PersonaDto agregarPersona(PersonaDto personaDto);

    List<Persona> consultarPersonas();

    void borrarPersona(int id);
}
