package com.inventario.controllers;

import com.inventario.dao.EquipoDao;
import com.inventario.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class EquipoControler {

    @Autowired
    private EquipoDao equipoDao;

    @RequestMapping(value = "equipos", method = RequestMethod.GET)
    public ArrayList<Equipo> getEquipos(){
        return equipoDao.getEquipos();
    }

    //Agregar 1 equipo
    @RequestMapping(value = "ingresar-equipo" , method = RequestMethod.POST)
    public void agregarEquipo(@RequestBody Equipo equipo){
        //con RequestBody: convierte el json que recibe en un objeto Equipo automaticamente.
        equipoDao.agregar(equipo);
    }

    //Eliminar 1 equipo
    @RequestMapping(value = "equipos/{id}" , method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id){
        equipoDao.eliminar(id);
    }

    //Editar 1 equipo
    @RequestMapping(value = "equipos/{id}", method = RequestMethod.PUT)
    public void editarEquipo(@PathVariable Equipo equipo){
        equipoDao.editarEquipo(equipo);
    }




}
