package com.example.exerciseCeiba.controladores;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.dto.PersonaDto;
import com.example.exerciseCeiba.entidades.Persona;
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

    @CrossOrigin
    @PostMapping("/agregar")
    @ResponseStatus(HttpStatus.OK)
    public PersonaDto createLibro(@RequestBody PersonaDto personaDto){
        return personaServicio.agregarPersona(personaDto);
    }

    @GetMapping("/consultar")
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> consultarPersonas(){
        return personaServicio.consultarPersonas();
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deletePersona(){

    }
}
