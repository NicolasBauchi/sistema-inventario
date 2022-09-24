const { t } = require("tar");

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


/* fin index */






/* cargados */
/* En esta seccion tengo que mostrar los equipos cargados */
mostrarListado();

async function mostrarListado() {
    let losEquipos = [];
    const info = await fetch('localhost:8080/equipos')
        .then((response) => response.json())
        .then((data) => {

            data.forEach((i) => {
                let e = new Equipo(i["id"], i["cliente"], i["propiedad"], i["serie"], i["tipo_equipo"], i["marca"], i["modelo"], i["servicio"], i["ubicacion"]);
                losEquipos.push(e);
            });

            cargarPagina(losEquipos);

        });
};

function cargarPagina(equipos) {

    let tabla = document.getElementById("tabla-equipos-nb");
    let trow = document.createElement("tr");

    let contador = 1;
    equipos.forEach(el => {
        let trow = document.createElement("tr");

        /* Llenamos los datos del ROW */
        for (let i = 0; i < 5; i++) {

            let td = document.createElement("td");

            if (i == 0) {
                td.innerHTML(String(contador));
            }
            if (i == 1) {
                td.innerHTML(String(el["serie"]));
            }
            if (i == 2) {
                td.innerHTML(String(el["tipo_equipo"]));
            }
            if (i == 3) {
                td.innerHTML(String(el["servicio"]));
            }
            if (i == 4) {
                td.innerHTML(
                    `<button type="button" class="btn btn-danger" id="${el["serie"]}">
                    <img src="imgs/trash-2-blanco.png" alt="">
                                </button>`);
            }
            trow.appendChild(td);
        }


    });







    /* <tr>
                            <td scope="row">123</th>
                            <td>047824963N</td>
                            <td>Electrobisturi</td>
                            <td>Quirofano</td>
                            <td>
                                <button type="button" class="btn btn-danger">
                                    <img src="imgs/trash-2-blanco.png" alt="">
                                </button>
                            </td>
                        </tr> */
};

/* fin cargados */



/* listas */
/* En esta seccion tengo que subir las listas a la BD */

/* fin listas */