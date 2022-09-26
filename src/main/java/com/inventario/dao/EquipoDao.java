package com.inventario.dao;

import com.inventario.models.Equipo;

import java.util.ArrayList;

public interface EquipoDao {
    //Consultar todos los equipos
    ArrayList<Equipo> getEquipos();

    //Consultar por 1 solo equipo
    public Equipo getEquipo(int id);

    //Editar equipo
    public void setEquipo(Equipo equipo);

    void eliminar(int id);
}
