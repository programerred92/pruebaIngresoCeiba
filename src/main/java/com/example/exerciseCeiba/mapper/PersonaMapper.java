package com.example.exerciseCeiba.mapper;

import com.example.exerciseCeiba.dto.PersonaDto;
import com.example.exerciseCeiba.entidades.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {

    public PersonaDto personaEntidadToDto(Persona persona){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setId(persona.getId());
        personaDto.setNombreCompleto(persona.getNombreCompleto());
        personaDto.setUser(persona.getUser());
        personaDto.setPassword(persona.getPass());
        personaDto.setRol(persona.getRol());
        return personaDto;
    }

    public Persona personaDtoToEntidad(PersonaDto personaDto){
        Persona persona = new Persona();
        persona.setId(personaDto.getId());
        persona.setNombreCompleto(personaDto.getNombreCompleto());
        persona.setUser(personaDto.getUser());
        persona.setPass(personaDto.getPassword());
        persona.setRol(personaDto.getRol());
        return persona;
    }
}
