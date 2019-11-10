package com.example.exerciseCeiba.repositorios;

import com.example.exerciseCeiba.dto.StockDto;
import com.example.exerciseCeiba.entidades.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepositorio extends JpaRepository<Stock, Integer> {

    @Query(value = "SELECT * FROM libros_stock WHERE isbn = ?1 ", nativeQuery = true)
    Optional<Stock> buscarStock(String isbn);

    /*Query(value = "UPDATE stock s SET s.cantidad_prestada = ")
    StockDto updateStock(StockDto stockDto);*/

}
