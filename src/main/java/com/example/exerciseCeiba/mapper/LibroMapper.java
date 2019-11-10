package com.example.exerciseCeiba.mapper;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    //Todo inyectar mapper de Stock y Prestamo

    public LibroDto libroEntidadToDto(Libro libro){
        return LibroDto.builder()
                .isbn(libro.getIsbn())
                .nombre(libro.getNombre())
                .build();
    }

    public Libro libroDtoToEntidad (LibroDto libroDto){
        Libro libro = new Libro();
        libro.setNombre(libroDto.getNombre());
        libro.setIsbn(libroDto.getIsbn());
        return libro;
    }
}
