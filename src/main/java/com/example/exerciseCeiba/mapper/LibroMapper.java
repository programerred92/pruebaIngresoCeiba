package com.example.exerciseCeiba.mapper;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public LibroDto libroEntidadToDto(Libro libro){
        LibroDto libroDto = new LibroDto();
        libroDto.setIsbn(libro.getIsbn());
        libroDto.setNombre(libro.getNombre());

        return libroDto;
    }

    public Libro libroDtoToEntidad (LibroDto libroDto){
        Libro libro = new Libro();
        libro.setIsbn(libroDto.getIsbn());
        libro.setNombre(libroDto.getNombre());
        return libro;
    }
}
