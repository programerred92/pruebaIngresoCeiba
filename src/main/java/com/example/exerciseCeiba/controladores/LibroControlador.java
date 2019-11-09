package com.example.exerciseCeiba.controladores;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.servicios.LibroServicio;
import com.example.exerciseCeiba.servicios.LibroServicioImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroControlador {

    LibroServicio libroServicio;

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LibroDto crearLibro(LibroDto libroDto){
        return libroServicio.agregarLibro(libroDto);
    }
}
