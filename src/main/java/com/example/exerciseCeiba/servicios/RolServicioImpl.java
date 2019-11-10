package com.example.exerciseCeiba.servicios;

import com.example.exerciseCeiba.dto.RolDto;
import com.example.exerciseCeiba.entidades.Rol;
import com.example.exerciseCeiba.mapper.RolMapper;
import com.example.exerciseCeiba.repositorios.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicioImpl implements RolServicio {

    private RolMapper rolMapper;
    private RolRepositorio rolRepositorio;

    public RolServicioImpl(RolMapper rolMapper, RolRepositorio rolRepositorio){
        this.rolMapper = rolMapper;
        this.rolRepositorio = rolRepositorio;
    }

    @Override
    public RolDto agregarRol(RolDto rolDto) {
        Rol rol = rolMapper.rolDtoToEntidad(rolDto);
        Rol rolGuardado = rolRepositorio.save(rol);
        return rolMapper.rolEntidadToDto(rolGuardado);
    }

    @Override
    public List<Rol> consultarRoles() {
        return rolRepositorio.findAll();
    }

    @Override
    public void eliminarRol(int id) {
        rolRepositorio.deleteById(id);
    }
}
