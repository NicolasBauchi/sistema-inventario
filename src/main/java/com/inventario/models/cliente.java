package com.inventario.models;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class cliente {

    @Column(name = "id")
    @Id
    int id;

    @Column(name = "nombre_cliente")
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
