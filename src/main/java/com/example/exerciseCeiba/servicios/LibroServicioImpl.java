package com.example.exerciseCeiba.servicios;


import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.excepciones.RegistroNoEncontradoException;
import com.example.exerciseCeiba.mapper.LibroMapper;
import com.example.exerciseCeiba.repositorios.LibroRepositorio;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void borrarLibro(String isbn) {
        try{
            libroRepositorio.deleteById(isbn);
        }catch (EmptyResultDataAccessException e){
            throw new RegistroNoEncontradoException("Error, no existe el libro");
        }
    }

    @Override
    public List<LibroDto> traerLibrosDisponibles() {
        return libroRepositorio.findAll()
                .stream()
                //.filter(libro -> libroEstaDisponible(libro))
                .map(libro -> libroMapper.libroEntidadToDto(libro))
                .collect(Collectors.toList());
    }
}
