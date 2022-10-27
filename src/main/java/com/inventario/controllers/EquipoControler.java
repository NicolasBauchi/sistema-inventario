package com.inventario.controllers;

import com.inventario.dao.EquipoDao;
import com.inventario.models.Equipo;
import com.inventario.service.ExportarCSV;
import com.inventario.service.ImprimirEtiqueta;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class EquipoControler {

    @Autowired
    private EquipoDao equipoDao;

    @Autowired
    private ExportarCSV exCSV;

    @Autowired
    private ImprimirEtiqueta ticket;

    @RequestMapping(value = "equipos", method = RequestMethod.GET)
    public ArrayList<Equipo> getEquipos(){
        return equipoDao.getEquipos();
    }

    //Agregar 1 equipo
    @RequestMapping(value = "ingresar-equipo" , method = RequestMethod.POST)
    public void agregarEquipo(@RequestBody Equipo equipo){
        //con RequestBody: convierte el json que recibe en un objeto Equipo automaticamente.
        equipoDao.agregar(equipo);

        //Acá tiene que imprimir:

        ticket.imprimir(equipo);
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

    // Vaciar / truncate tabla equipos
    @RequestMapping(value = "vaciar/equipos", method = RequestMethod.GET)
    public void vaciarTablaEquipos(){
        equipoDao.vaciarEquipos();
    }

    @RequestMapping(value = "descargarListado", method = RequestMethod.GET)
    public void imprimirInfo(HttpServletResponse servletResponse) throws IOException {

        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"listado.csv\"");
        exCSV.listadoEquipos(servletResponse.getWriter());
    }

}
