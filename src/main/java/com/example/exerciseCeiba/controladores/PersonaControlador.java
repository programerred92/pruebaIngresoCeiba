package com.example.exerciseCeiba.controladores;

import com.example.exerciseCeiba.dto.PersonaDto;
import com.example.exerciseCeiba.entidades.Persona;
import com.example.exerciseCeiba.mapper.PersonaMapper;
import com.example.exerciseCeiba.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaControlador {

    @Autowired
    private PersonaServicio personaServicio;
    private PersonaMapper personaMapper;

    @PostMapping("/agregar")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonaDto crearPersona(@RequestBody PersonaDto personaDto){
        return personaServicio.agregarPersona(personaDto);
    }

    @GetMapping("/consultar")
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> consultarPersonas(){
        return personaServicio.consultarPersonas();
    }

    @DeleteMapping("/borrar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePersona(@PathVariable int id){
            personaServicio.borrarPersona(id);
    }

    @PutMapping("/actualizar")
    @ResponseStatus(HttpStatus.OK)
    public PersonaDto actualizarPersona(@RequestBody PersonaDto personaDto){
        return personaServicio.agregarPersona(personaDto);
    }

}
