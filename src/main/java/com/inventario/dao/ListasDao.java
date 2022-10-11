package com.inventario.dao;

import com.inventario.models.Marca;
import com.inventario.models.Servicios;
import com.inventario.models.TipoEquipos;
import com.inventario.models.Cliente;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ListasDao {

    //Tabla Cliente
    public ArrayList<Cliente> nombresClientes(); //listado
    public Cliente getCliente(int id);
    public void agregarCliente(Cliente cliente1);
    public void agregarMuchosClientes(ArrayList<String> losClientes);



    //Tabla Marca
    public ArrayList<Marca> nombresMarcas(); //listado
    public Marca getMarca(int id);
    public void agregarMarca(Marca marca);
    public void agregarMuchasMarcas(ArrayList<Marca> lasMarcas);


    //Tabla Servicios
    public ArrayList<Servicios> nombresServicios(); //listado
    public Servicios getServicios(int id);
    public void agregarServicios(Servicios servicios);
    public void agregarMuchosServicios(ArrayList<Servicios> losServicios);


    //Tabla Tipo de equipos
    public ArrayList<TipoEquipos> nombresTipoEquipos(); //listado
    public TipoEquipos getTipoEquipos(int id);
    public void agregarTipoEquipos(TipoEquipos tipoEquipos);
    public void agregarMuchosTipoEquipos(ArrayList<TipoEquipos> losTipoEquipos);

}
