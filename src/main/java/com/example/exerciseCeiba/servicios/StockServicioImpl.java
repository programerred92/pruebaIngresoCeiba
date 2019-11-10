package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.entidades.Stock;
import com.example.exerciseCeiba.excepciones.RegistroNoEncontradoException;
import com.example.exerciseCeiba.mapper.StockMapper;
import com.example.exerciseCeiba.repositorios.StockRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServicioImpl implements StockServicio {

    private StockMapper stockMapper;
    private StockRepositorio stockRepositorio;

    public StockServicioImpl(StockMapper stockMapper, StockRepositorio stockRepositorio){
        this.stockMapper = stockMapper;
        this.stockRepositorio = stockRepositorio;
    }

    @Override
    public Optional<Stock> buscarLibro(String isbn) {
        Optional<Stock> stock = stockRepositorio.buscarStock(isbn);
        if(!stock.isPresent()){
            throw new RegistroNoEncontradoException("ISBN no existe");
        }
        return stock;
    }
}
