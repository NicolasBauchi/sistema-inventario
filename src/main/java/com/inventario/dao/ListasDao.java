package com.inventario.dao;

import com.inventario.models.Marca;
import com.inventario.models.Servicios;
import com.inventario.models.TipoEquipos;
import com.inventario.models.cliente;

import java.util.ArrayList;

public interface ListasDao {

    //Tabla Cliente
    public ArrayList<cliente> nombresClientes(); //listado
    public cliente getCliente(int id);
    public void agregarCliente(cliente cliente1);



    //Tabla Marca
    public ArrayList<Marca> nombresMarcas(); //listado
    public Marca getMarca(int id);
    public void agregarMarca(Marca marca);


    //Tabla Servicios
    public ArrayList<Servicios> nombresServicios(); //listado
    public Servicios getServicios(int id);
    public void agregarServicios(Servicios servicios);


    //Tabla Tipo de equipos
    public ArrayList<TipoEquipos> nombresTipoEquipos(); //listado
    public TipoEquipos getTipoEquipos(int id);
    public void agregarTipoEquipos(TipoEquipos tipoEquipos);

}
