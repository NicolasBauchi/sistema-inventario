package com.inventario.models;

import javax.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "propiedad")
    private String propiedad;
    @Column(name = "serie")
    private String serie;
    @Column(name = "tipo")
    private String tipo_equipo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "servicio")
    private String servicio;
    @Column(name = "ubicacion")
    private String ubicacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo_equipo() {
        return tipo_equipo;
    }

    public void setTipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    //Data para imprimir:
    public String generarTicket(){
        String data = "";

        //Logo biotrust
        data+= "BIOTRUST" + "\n";

        //QR
        data+= "codigo de QR para copiar";

        //Datos del equipo
        data+= this.getCliente() + "\n";
        data+= "SN: " + this.getSerie() + "\n";
        data+= "Mod: " + this.getModelo() + "\n";
        data+= "Marca: " + this.getMarca() + "\n";
        data+= "Typ: " + this.getTipo_equipo() + "\n";

        return data;
    }
}