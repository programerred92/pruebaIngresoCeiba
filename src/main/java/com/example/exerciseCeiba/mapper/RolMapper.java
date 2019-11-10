package com.example.exerciseCeiba.mapper;

import com.example.exerciseCeiba.dto.LibroDto;
import com.example.exerciseCeiba.dto.RolDto;
import com.example.exerciseCeiba.entidades.Libro;
import com.example.exerciseCeiba.entidades.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    public RolDto rolEntidadToDto(Rol rol){
        RolDto rolDto = new RolDto();
        rolDto.setId(rol.getId());
        rolDto.setNombre(rol.getNombre());
        return rolDto;
    }

    public Rol rolDtoToEntidad (RolDto rolDto){
        Rol rol = new Rol();
        rol.setId(rolDto.getId());
        rol.setNombre(rolDto.getNombre());
        return rol;
    }
}
