package com.inventario.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ClienteDaoImpl implements ClienteDao{

    @PersistenceContext
    private EntityManager entityManager;



}
