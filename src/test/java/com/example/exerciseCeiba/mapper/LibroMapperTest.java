package com.example.exerciseCeiba.mapper;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import org.junit.Assert;
import org.junit.Test;


public class LibroMapperTest {

    private LibroMapper libroMapper = new LibroMapper();

    private static final String ISBN_TEST = "ISBN_TEST";
    private static final String NOMBRE_TEST = "NOMBRE_TEST";

    @Test
    public void dtoTOEntityTest() {
        //given
        LibroDto libroDto = crearLibroDto();

        //when
        Libro libro = libroMapper.libroDtoToEntidad(libroDto);

        //then
        Assert.assertEquals(libro.getIsbn(), libroDto.getIsbn());
        Assert.assertEquals(libro.getNombre(), libroDto.getNombre());
    }

    @Test
    public void entityToDtoTest() {
        //given
        Libro libro = crearLibroEntity();

        //when
        LibroDto libroDto = libroMapper.libroEntidadToDto(libro);

        //then
        Assert.assertEquals(libroDto.getIsbn(), libro.getIsbn());
        Assert.assertEquals(libroDto.getNombre(), libro.getNombre());
    }

    private Libro crearLibroEntity() {
        return Libro.builder()
                .isbn(ISBN_TEST)
                .nombre(NOMBRE_TEST)
                .build();
    }


    private LibroDto crearLibroDto() {
        return LibroDto.builder()
                .isbn(ISBN_TEST)
                .nombre(NOMBRE_TEST)
                .build();
    }
}