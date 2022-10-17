package com.inventario.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.inventario.dao.ListasDao;
import com.inventario.models.*;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonString;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ListasControler {

    @Autowired
    private ListasDao listasDao;

    /* Subiendo las tablas a la BD: **/
    @RequestMapping(value = "subirTablas/clientes", method = RequestMethod.POST)
    public void subirTablaCliente(@RequestBody Cliente cl){
        listasDao.agregarCliente(cl);
    }
    @RequestMapping(value = "subirTablas/marcas", method = RequestMethod.POST)
    public void subirTablaMarca(@RequestBody Marca marca){
        listasDao.agregarMarca(marca);
    }

    @RequestMapping(value = "subirTablas/servicios", method = RequestMethod.POST)
    public void subirTablaServicio(@RequestBody Servicios servicios){
        listasDao.agregarServicios(servicios);

    }
    @RequestMapping(value = "subirTablas/tipoEquipos", method = RequestMethod.POST)
    public void subirTablaTipoEquipo(@RequestBody TipoEquipos tipoEquipos){
        listasDao.agregarTipoEquipos(tipoEquipos);

    }
}
