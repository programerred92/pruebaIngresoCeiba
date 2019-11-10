package com.example.exerciseCeiba.mapper;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public LibroDto libroEntidadToDto(Libro libro){
        return LibroDto.builder()
                .isbn(libro.getIsbn())
                .nombre(libro.getNombre())
                .build();
    }

    public Libro libroDtoToEntidad (LibroDto libroDto){
        return Libro.builder()
                .isbn(libroDto.getIsbn())
                .nombre(libroDto.getNombre())
                .build();
    }
}
