package com.inventario.controllers;

import com.inventario.dao.EquipoDao;
import com.inventario.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
