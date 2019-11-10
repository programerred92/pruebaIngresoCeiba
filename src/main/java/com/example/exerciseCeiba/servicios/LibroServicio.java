package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.dto.LibroDto;

import java.util.List;

public interface LibroServicio {

    LibroDto agregarLibro(LibroDto libroDto);

    void borrarLibro(String isbn);

    List<LibroDto> traerLibrosDisponibles();

    LibroDto prestarLibro(String isbn, String prestador);
}
