package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.entidades.Stock;
import com.example.exerciseCeiba.mapper.StockMapper;
import com.example.exerciseCeiba.repositorios.StockRepositorio;
import org.springframework.stereotype.Service;

@Service
public class StockServicioImpl implements StockServicio {

    private StockMapper stockMapper;
    private StockRepositorio stockRepositorio;

    public StockServicioImpl(StockMapper stockMapper, StockRepositorio stockRepositorio){
        this.stockMapper = stockMapper;
        this.stockRepositorio = stockRepositorio;
    }

    //@Override
    public Stock prestarLibro(String isbn) {

        return null;
    }
}
