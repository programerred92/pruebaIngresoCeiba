package com.example.exerciseCeiba.controladores;

import com.example.exerciseCeiba.entidades.Stock;
import com.example.exerciseCeiba.servicios.StockServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockControlador {
    @Autowired
    private StockServicio stockServicio;

    @GetMapping("/buscarLibro")
    public Optional<Stock> buscarLibro(@RequestParam(name = "isbn") String isbn){
        return stockServicio.buscarLibro(isbn);
    }

    @GetMapping("/buscarStock")
    public List<Stock> buscarStock(){
        return stockServicio.buscarStock();
    }


}
