package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.dto.PersonaDto;
import com.example.exerciseCeiba.entidades.Persona;
import com.example.exerciseCeiba.entidades.Rol;
import com.example.exerciseCeiba.excepciones.RegistroNoEncontradoException;
import com.example.exerciseCeiba.mapper.PersonaMapper;
import com.example.exerciseCeiba.repositorios.PersonaRepositorio;
import com.example.exerciseCeiba.repositorios.RolRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicioImpl implements PersonaServicio {

    private PersonaMapper personaMapper;
    private PersonaRepositorio personaRepositorio;
    private RolRepositorio rolRepositorio;

    public PersonaServicioImpl(PersonaMapper personaMapper, PersonaRepositorio personaRepositorio, RolRepositorio rolRepositorio){
        this.personaMapper = personaMapper;
        this.personaRepositorio = personaRepositorio;
        this.rolRepositorio = rolRepositorio;
    }

    public PersonaDto agregarPersona(PersonaDto personaDto){
        Persona persona;
        Persona personaGuardada;
        Optional<Rol> rolRetornado = rolRepositorio.findById(personaDto.getRol().getId());
        if(rolRetornado.isPresent()){
            persona = personaMapper.personaDtoToEntidad(personaDto);
            personaGuardada = personaRepositorio.save(persona);
        }
        else{
            throw new RegistroNoEncontradoException("Rol no existe");
        }
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
