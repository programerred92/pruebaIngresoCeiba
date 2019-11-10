package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.entidades.Stock;

import java.util.List;
import java.util.Optional;

public interface StockServicio {

    Optional<Stock> buscarLibro(String isbn);

    List<Stock> buscarStock();

    //Stock prestarLibro(String isbn);
}
