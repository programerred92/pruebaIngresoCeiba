package com.example.exerciseCeiba.controladores;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.servicios.LibroServicio;
import com.example.exerciseCeiba.servicios.LibroServicioImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libro")
public class LibroControlador {


    LibroServicio libroServicio;

    @CrossOrigin
    @PostMapping("/libro")
    @ResponseStatus(HttpStatus.OK)
    public LibroDto crearLibro(@RequestBody LibroDto libroDto){
        return libroServicio.agregarLibro(libroDto);
    }
}
