package com.example.exerciseCeiba.servicios;


import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.mapper.LibroMapper;
import com.example.exerciseCeiba.repositorios.LibroRepositorio;
import org.springframework.stereotype.Service;

@Service
public class LibroServicioImpl implements LibroServicio {

    LibroMapper libroMapper;
    LibroRepositorio libroRepositorio;

    public LibroServicioImpl(LibroMapper libroMapper, LibroRepositorio libroRepositorio) {
        this.libroMapper = libroMapper;
        this.libroRepositorio = libroRepositorio;
    }

    @Override
    public LibroDto agregarLibro(LibroDto libroDto) {
        Libro libro = libroMapper.libroDtoToEntidad(libroDto);
        Libro libroGuardado = libroRepositorio.save(libro);
        return libroMapper.libroEntidadToDto(libroGuardado);
    }
}
