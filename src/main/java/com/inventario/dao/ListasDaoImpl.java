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
    public ArrayList<Cliente> nombresClientes() {
        //Esto es lenguaje SQL puro. - Usando esta opción no devuelve objeto Cliente en Front,
        // solo un array de arrays.
        String queryN = "SELECT * FROM clientes ORDER BY nombre_cliente";
        return (ArrayList<Cliente>) entityManager.createNativeQuery(queryN).getResultList();


        //String query = "FROM Cliente";
        //return (ArrayList<Cliente>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public Cliente getCliente(int id) {
        String query = "FROM Cliente WHERE id='" + id+"'";
        return (Cliente) entityManager.createQuery(query).getResultList();
    }

    @Override
    public void agregarCliente(Cliente cliente1) {
        entityManager.merge(cliente1);
    }

    @Override
    public void agregarMuchosClientes(ArrayList<String> losClientes) {

        for (int i = 0; i < losClientes.size(); i++) {

            Cliente cl = new Cliente();
            cl.setNombre(""+i);
            entityManager.merge(cl);
        }

    }

    @Override
    @Transactional
    public void truncarTablaClientes() {
        //String query = "TRUNCATE TABLE Cliente";
        //entityManager.createNativeQuery(query);


        //Esto es lenguaje SQL puro.
        String queryN = "TRUNCATE TABLE clientes";
        entityManager.createNativeQuery(queryN).getResultList();
    }


    //Tabla marcas

    @Override
    public ArrayList<Marca> nombresMarcas() {
        //Esto es lenguaje SQL puro.
        String queryN = "SELECT * FROM marcas ORDER BY nombre_marcas";
        return (ArrayList<Marca>) entityManager.createNativeQuery(queryN).getResultList();


        //String query = "FROM Marca";
        //return (ArrayList<Marca>) entityManager.createQuery(query).getResultList();
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

    @Override
    public void agregarMuchasMarcas(ArrayList<Marca> lasMarcas) {
        entityManager.merge(lasMarcas);
    }

    //Tabla servicios

    @Override
    public ArrayList<Servicios> nombresServicios() {
        //Esto es lenguaje SQL puro.
        String queryN = "SELECT * FROM servicios ORDER BY nombre_servicios";
        return (ArrayList<Servicios>) entityManager.createNativeQuery(queryN).getResultList();

       // String query = "FROM Servicios";
       // return (ArrayList<Servicios>) entityManager.createQuery(query).getResultList();
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

    @Override
    public void agregarMuchosServicios(ArrayList<Servicios> losServicios) {

    }

    //Tabla tipo equipos

    @Override
    public ArrayList<TipoEquipos> nombresTipoEquipos() {
        //Esto es lenguaje SQL puro.
        String queryN = "SELECT * FROM tipoequipos ORDER BY nombre_tipos";
        return (ArrayList<TipoEquipos>) entityManager.createNativeQuery(queryN).getResultList();

        //String query = "FROM TipoEquipos";
        //return (ArrayList<TipoEquipos>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public TipoEquipos getTipoEquipos(int id) {
        String query = "FROM TipoEquipos WHERE id='" + id + "'";
        return (TipoEquipos) entityManager.createQuery(query).getResultList();
    }

    @Override
    public void agregarTipoEquipos(TipoEquipos tipoEquipos) {
        entityManager.merge(tipoEquipos);
    }

    @Override
    public void agregarMuchosTipoEquipos(ArrayList<TipoEquipos> losTipoEquipos) {

    }
}