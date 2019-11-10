package com.example.exerciseCeiba.servicios;


import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.entidades.Stock;
import com.example.exerciseCeiba.excepciones.RegistroNoEncontradoException;
import com.example.exerciseCeiba.mapper.LibroMapper;
import com.example.exerciseCeiba.mapper.StockMapper;
import com.example.exerciseCeiba.repositorios.LibroRepositorio;
import com.example.exerciseCeiba.repositorios.StockRepositorio;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroServicioImpl implements LibroServicio {

    private final LibroMapper libroMapper;
    private final LibroRepositorio libroRepositorio;
    private final StockRepositorio stockRepositorio;
    private final StockMapper stockMapper;
    private Libro libro;

    public LibroServicioImpl(LibroMapper libroMapper, LibroRepositorio libroRepositorio, StockRepositorio stockRepositorio, StockMapper stockMapper) {
        this.libroMapper = libroMapper;
        this.libroRepositorio = libroRepositorio;
        this.stockRepositorio = stockRepositorio;
        this.stockMapper = stockMapper;
    }

    @Override
    public LibroDto agregarLibro(LibroDto libroDto) {
        Optional<Libro> libroRetornado = libroRepositorio.findById(libroDto.getIsbn());
        if (libroRetornado.isPresent()) {
            this.libro = libroRetornado.get();
            Integer cantidadActualStock = libro.getStock().getCantidadDisponible();
            this.libro.getStock().setCantidadDisponible(cantidadActualStock + 1);
        } else {
            this.libro = libroMapper.libroDtoToEntidad(libroDto);
            this.libro.setStock(stockBasico());
        }
        Libro libroGuardado = libroRepositorio.save(libro);
        return libroMapper.libroEntidadToDto(libroGuardado);
    }

    @Override
    public void borrarLibro(String isbn) {
        Libro libro;
        Optional<Libro> libroRetornado = libroRepositorio.findById(isbn);
        if (noExistenLibrosDisponibles(libroRetornado)) {
            throw new RegistroNoEncontradoException("No Existen Libros con el isbn " + isbn);
        }
        libro = libroRetornado.get();
        Integer cantidadActualStock = libro.getStock().getCantidadDisponible();
        libro.getStock().setCantidadDisponible(cantidadActualStock - 1);
        libroRepositorio.save(libro);
    }

    private boolean noExistenLibrosDisponibles(Optional<Libro> libroRetornado) {
        if (!libroRetornado.isPresent()) {
            return true;
        }

        if (libroRetornado.get().getStock().getCantidadDisponible() == Integer.valueOf(0)) {
            return true;
        }

        return false;
    }

    @Override
    public List<LibroDto> traerLibrosDisponibles() {
        return libroRepositorio.findAll()
                .stream()
                //.filter(libro -> libroEstaDisponible(libro))
                .map(libro -> libroMapper.libroEntidadToDto(libro))
                .collect(Collectors.toList());
    }

    private Stock stockBasico() {
        Stock stock = new Stock();
        stock.setCantidadDisponible(1);
        stock.setCantidadPrestada(0);
        stock.setIsbn(libro.getIsbn());
        return stock;
    }

}
