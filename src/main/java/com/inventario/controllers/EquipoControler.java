package com.inventario.controllers;

import com.inventario.dao.EquipoDao;
import com.inventario.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EquipoControler {

    @Autowired
    private EquipoDao equipoDao;

    @RequestMapping("equipos")
    public ArrayList<Equipo> getEquipos(){
        return equipoDao.getEquipos();
    }

    //Buscar 1 equipo
    @RequestMapping(value = "equipos/{id}" , method = RequestMethod.GET)
    public Equipo buscar(@PathVariable int id){
        return null;
    }

    //Eliminar 1 equipo
    @RequestMapping(value = "equipos/{id}" , method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id){
        equipoDao.eliminar(id);
    }

    //Editar 1 equipo

}
