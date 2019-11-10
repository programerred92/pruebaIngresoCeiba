package com.example.exerciseCeiba.controladores;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.servicios.LibroServicio;
import com.example.exerciseCeiba.servicios.LibroServicioImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class LibroControlador {

    private final LibroServicio libroServicio;

    public LibroControlador(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
    }

    @CrossOrigin
    @PostMapping("/libro")
    @ResponseStatus(HttpStatus.CREATED)
    public LibroDto crearLibro(@RequestBody LibroDto libroDto){
        return libroServicio.agregarLibro(libroDto);
    }

    @CrossOrigin
    @DeleteMapping("/libro/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public void borrarLibro(@PathVariable String isbn){
        libroServicio.borrarLibro(isbn);
    }

    @CrossOrigin
    @GetMapping("/librosDisponibles")
    @ResponseStatus(HttpStatus.OK)
    public List<LibroDto> traerLibrosDisponibles(){
        return libroServicio.traerLibrosDisponibles();
    }

    @CrossOrigin
    @PostMapping("/prestarLibro/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public LibroDto prestarLibro(@PathVariable String isbn,@RequestParam("prestador") String prestador){
        return libroServicio.prestarLibro(isbn, prestador);
    }
}
