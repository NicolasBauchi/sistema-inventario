package com.inventario.service;


import com.inventario.dao.EquipoDao;
import com.inventario.models.Equipo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

@Service
public class ExportarCSV {


    @Autowired
    private EquipoDao equipoDao;

    public void listadoEquipos(Writer writer) {

        ArrayList<Equipo> losEquipos = equipoDao.getEquipos();
// timestamp;tipo+marca+sn;tipo equipo;marca;sn;modelo;servicio;;;;;cliente;ubicación; ;Propiedad;
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withDelimiter(';'))) {

            for (Equipo equipo : losEquipos) {
                String tipo = equipo.getTipo_equipo();
                String marca = equipo.getMarca();
                String serie = equipo.getSerie();
                String modelo = equipo.getModelo();
                String tms = tipo +" "+ marca +" "+ serie;
                String servicio = equipo.getServicio();
                String cliente = equipo.getCliente();
                String ubicacion = equipo.getUbicacion();
                String propiedad = equipo.getPropiedad();

                csvPrinter.printRecord("", tms,tipo,marca,serie,
                        modelo, servicio,"","","","", cliente, ubicacion, "", propiedad, "");
            }

        } catch (IOException e) {
            //log.error("Error While writing CSV ", e);
        }
    }


}
