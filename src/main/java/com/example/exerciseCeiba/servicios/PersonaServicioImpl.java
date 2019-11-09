package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.dto.PersonaDto;
import com.example.exerciseCeiba.entidades.Persona;
import com.example.exerciseCeiba.mapper.LibroMapper;
import com.example.exerciseCeiba.mapper.PersonaMapper;
import com.example.exerciseCeiba.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicioImpl implements PersonaServicio {

    PersonaMapper personaMapper;
    PersonaRepositorio personaRepositorio;

    public PersonaServicioImpl(PersonaMapper personaMapper, PersonaRepositorio personaRepositorio){
        this.personaMapper = personaMapper;
        this.personaRepositorio = personaRepositorio;
    }

    public PersonaDto agregarPersona(PersonaDto personaDto){
        Persona persona = personaMapper.personaDtoToEntidad(personaDto);
        Persona personaGuardada = personaRepositorio.save(persona);
        return personaMapper.personaEntidadToDto(personaGuardada);
    }

    @Override
    public List<Persona> consultarPersonas() {

        return personaRepositorio.findAll();
    }

    public void borrarPersona(int id) {
        personaRepositorio.deleteById(id);
    }


}
