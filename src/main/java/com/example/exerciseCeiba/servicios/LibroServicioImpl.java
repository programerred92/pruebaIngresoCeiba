package com.example.exerciseCeiba.servicios;


import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.entidades.Prestamo;
import com.example.exerciseCeiba.entidades.Stock;
import com.example.exerciseCeiba.excepciones.IsbnPalindromoException;
import com.example.exerciseCeiba.excepciones.RegistroNoEncontradoException;
import com.example.exerciseCeiba.mapper.LibroMapper;
import com.example.exerciseCeiba.mapper.StockMapper;
import com.example.exerciseCeiba.repositorios.LibroRepositorio;
import com.example.exerciseCeiba.repositorios.StockRepositorio;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroServicioImpl implements LibroServicio {

    private final LibroMapper libroMapper;
    private final LibroRepositorio libroRepositorio;
    private Libro libro;

    public LibroServicioImpl(LibroMapper libroMapper, LibroRepositorio libroRepositorio) {
        this.libroMapper = libroMapper;
        this.libroRepositorio = libroRepositorio;
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

    @Override
    public List<LibroDto> traerLibrosDisponibles() {
        return libroRepositorio.findAll()
                .stream()
                .map(libro -> libroMapper.libroEntidadToDto(libro))
                .collect(Collectors.toList());
    }

    @Override
    public LibroDto prestarLibro(String isbn) {
        Libro libro;
        Optional<Libro> libroRetornado = libroRepositorio.findById(isbn);
        if (noExistenLibrosDisponibles(libroRetornado)) {
            throw new RegistroNoEncontradoException("No Existen Libros con el isbn " + isbn);
        }

        libro = libroRetornado.get();
        LocalDate fechaMaxinaEntrega = calcularFechaMaximaEntrega(isbn);
        Integer cantidadDisponibleActual = libro.getStock().getCantidadDisponible();
        Integer cantidadPrestadosActual = libro.getStock().getCantidadPrestada();
        libro.getStock().getPrestamos().add(crearPrestamo(fechaMaxinaEntrega));
        libro.getStock().setCantidadDisponible(cantidadDisponibleActual - 1);
        libro.getStock().setCantidadPrestada(cantidadPrestadosActual + 1);
        Libro libroConNuevaReserva = libroRepositorio.save(libro);

        return libroMapper.libroEntidadToDto(libroConNuevaReserva);
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


    private LocalDate calcularFechaMaximaEntrega(String isbn) {
        String reverseIsbn = new StringBuilder(isbn).reverse().toString();
        if (reverseIsbn == isbn) {
            throw new IsbnPalindromoException("Los Libros palindromos solo se pueden utilizar en la biblioteca");
        }

        Integer sumaIsbn = sumaNumerosIsbn(isbn);
        if (sumaIsbn <= 30) {
            return null;
        } else {
            //todo Aplicar logica para que cuente los domingos
            return LocalDate.now().plusDays(15);
        }

    }

    private Integer sumaNumerosIsbn(String isbn) {
        String extraerNumeros = isbn.replaceAll("[^0-9]", "");
        Integer sumaIsbn = 0;
        for (char c : extraerNumeros.toCharArray()) {
            sumaIsbn = sumaIsbn + Integer.valueOf(c);
        }
        return sumaIsbn;
    }

    private Prestamo crearPrestamo(LocalDate fechaMaximaEntrega) {
        Prestamo prestamo = new Prestamo();
        prestamo.setFechaDeEntrega(LocalDate.now());
        prestamo.setFechaDePrestamo(fechaMaximaEntrega);
        return prestamo;
    }

    private Stock stockBasico() {
        Stock stock = new Stock();
        stock.setCantidadDisponible(1);
        stock.setCantidadPrestada(0);
        stock.setIsbn(libro.getIsbn());
        return stock;
    }

}
