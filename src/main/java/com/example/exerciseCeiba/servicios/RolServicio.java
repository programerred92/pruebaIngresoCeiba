package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.dto.RolDto;
import com.example.exerciseCeiba.entidades.Rol;

import java.util.List;

public interface RolServicio {

    List<Rol> consultarRoles();

    RolDto agregarRol(RolDto rolDto);

    void eliminarRol(int id);

}
