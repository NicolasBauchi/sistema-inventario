package com.inventario.dao;

import com.inventario.models.Equipo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Repository
@Transactional
public class EquipoDaoImpl implements EquipoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ArrayList<Equipo> getEquipos() {
       String query = "SELECT * FROM Equipo";
       return (ArrayList<Equipo>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public Equipo getEquipo(int id) {
        String query = "SELECT * FROM Equipo WHERE id=" + id;
        return (Equipo) entityManager.createQuery(query).getResultList();
    }

    //Editar equipo
    @Override
    public void setEquipo(Equipo equipo) {

    }



}
