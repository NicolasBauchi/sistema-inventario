
/* Clases */
class Equipo {

    constructor(id, cliente, propiedad, serie, tipo_equipo, marca, modelo, servicio, ubicacion) {
        this.id = id;
        this.cliente = cliente;
        this.propiedad = propiedad;
        this.serie = serie;
        this.tipo_equipo = tipo_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.servicio = servicio;
        this.ubicacion = ubicacion;
    }
}

/* fin clases */

/* index */
/* Aca tengo recibir los datos y procesarlos en el BACK. */

/* Seccion registro de equipo */
async function registrarEquipo() {

    let datos = {};
    datos.cliente = document.getElementById("form-cliente").value;
    datos.propiedad = document.getElementById("form-propiedad").value;
    datos.serie = document.getElementById("form-nroserie").value;
    datos.tipo_equipo = document.getElementById("form-tipoequipo").value;
    datos.marca = document.getElementById("form-marca").value;
    datos.modelo = document.getElementById("form-modelo").value;
    datos.servicio = document.getElementById("form-servicio").value;
    datos.ubicacion = document.getElementById("form-ubicacion").value;

    const resp = await fetch('equipos', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
}

/* Seccion imprimir */

/* fin index */










/* listas */
/* En esta seccion tengo que subir las listas a la BD */

/* fin listas */