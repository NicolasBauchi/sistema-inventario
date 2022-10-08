package com.inventario.controllers;


import com.inventario.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ListasControler {

    @Autowired
    private ClienteDao clienteDao;

    /* Subiendo las tablas a la BD: **/
    @RequestMapping(value = "subirTablas/clientes", method = RequestMethod.POST)
    public void subirTablaCliente(ArrayList<String> elListado){
        //completar !!

    }
    @RequestMapping(value = "subirTablas/marcas", method = RequestMethod.POST)
    public void subirTablaMarca(@PathVariable ArrayList<String> elListado){
        //completar !!

    }

    @RequestMapping(value = "subirTablas/servicios", method = RequestMethod.POST)
    public void subirTablaServicio(@PathVariable ArrayList<String> elListado){
        //completar !!

    }
    @RequestMapping(value = "subirTablas/tipoEquipos", method = RequestMethod.POST)
    public void subirTablaTipoEquipo(@PathVariable ArrayList<String> elListado){
        //completar !!

    }
}
