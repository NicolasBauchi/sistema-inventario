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
/*
        String[] renglones = data.split("\r\n");


        for (int i = 0; i < renglones.length; i++) {
            String[] columnas = renglones[i].split(";");


            cliente cl = new cliente();
            cl.setNombre(columnas[0]);
            listasDao.agregarCliente(cl);
        }

        //String[] renglones = laTabla.split("\r\n");

       /*for (int i = 0; i < cls.getLosClientes().size(); i++) {
            cliente cl =  cls.getLosClientes().get(i);
            listasDao.agregarCliente(cl);
        }**/



    }
    @RequestMapping(value = "subirTablas/marcas", method = RequestMethod.POST)
    public void subirTablaMarca(@PathVariable ArrayList<Marca> elListado){
        listasDao.agregarMuchasMarcas(elListado);
    }

    @RequestMapping(value = "subirTablas/servicios", method = RequestMethod.POST)
    public void subirTablaServicio(@PathVariable ArrayList<Servicios> elListado){
        listasDao.agregarMuchosServicios(elListado);

    }
    @RequestMapping(value = "subirTablas/tipoEquipos", method = RequestMethod.POST)
    public void subirTablaTipoEquipo(@PathVariable ArrayList<TipoEquipos> elListado){
        listasDao.agregarMuchosTipoEquipos(elListado);

    }
}
