package com.example.exerciseCeiba.mapper;

import com.example.exerciseCeiba.dto.RolDto;
import com.example.exerciseCeiba.dto.StockDto;
import com.example.exerciseCeiba.entidades.Rol;
import com.example.exerciseCeiba.entidades.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    public Stock stockDtoToEntidad(StockDto stockDto){
        Stock stock = new Stock();
        stock.setId(stockDto.getId());

        return stock;
    }

    public StockDto stockEntityToDto(Stock stock){
        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getId());
        return stockDto;
    }
}
