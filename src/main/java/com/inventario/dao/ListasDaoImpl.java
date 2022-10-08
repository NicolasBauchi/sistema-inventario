package com.inventario.dao;

import com.inventario.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Repository
@Transactional
public class ListasDaoImpl implements ListasDao{

    @PersistenceContext
    private EntityManager entityManager;

    //Tabla clientes

    @Override
    public ArrayList<cliente> nombresClientes() {
        String query = "FROM cliente";
        return (ArrayList<cliente>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public cliente getCliente(int id) {
        String query = "FROM cliente WHERE id='" + id+"'";
        return (cliente) entityManager.createQuery(query).getResultList();
    }

    @Override
    public void agregarCliente(cliente cliente1) {
        entityManager.merge(cliente1);
    }


    //Tabla marcas

    @Override
    public ArrayList<Marca> nombresMarcas() {
        String query = "FROM Marca";
        return (ArrayList<Marca>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public Marca getMarca(int id) {
        String query = "FROM Marca WHERE id='" + id+"'";
        return (Marca) entityManager.createQuery(query).getResultList();
    }

    @Override
    public void agregarMarca(Marca marca) {
        entityManager.merge(marca);
    }

    //Tabla servicios

    @Override
    public ArrayList<Servicios> nombresServicios() {
        String query = "FROM servicios";
        return (ArrayList<Servicios>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public Servicios getServicios(int id) {
        String query = "FROM Servicios WHERE id='" + id+"'";
        return (Servicios) entityManager.createQuery(query).getResultList();
    }

    @Override
    public void agregarServicios(Servicios servicios) {
        entityManager.merge(servicios);
    }

    //Tabla tipo equipos

    @Override
    public ArrayList<TipoEquipos> nombresTipoEquipos() {
        String query = "FROM tipoequipos";
        return (ArrayList<TipoEquipos>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public TipoEquipos getTipoEquipos(int id) {
        String query = "FROM TipoEquipos WHERE id='" + id+"'";
        return (TipoEquipos) entityManager.createQuery(query).getResultList();
    }

    @Override
    public void agregarTipoEquipos(TipoEquipos tipoEquipos) {
        entityManager.merge(tipoEquipos);
    }
}