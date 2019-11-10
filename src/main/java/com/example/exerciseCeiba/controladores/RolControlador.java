package com.example.exerciseCeiba.controladores;

import com.example.exerciseCeiba.dto.RolDto;
import com.example.exerciseCeiba.entidades.Rol;
import com.example.exerciseCeiba.servicios.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolControlador {

    @Autowired
    private RolServicio rolServicio;

    @PostMapping("/agregar")
    @ResponseStatus(HttpStatus.CREATED)
    public RolDto crearRol(@RequestBody RolDto rolDto){
        return rolServicio.agregarRol(rolDto);
    }

    @GetMapping("/consultar")
    @ResponseStatus(HttpStatus.OK)
    public List<Rol> consultarRoles(){
        return rolServicio.consultarRoles();
    }

    @DeleteMapping("/borrar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void borrarRol(@PathVariable int id){
        rolServicio.eliminarRol(id);
    }
}
