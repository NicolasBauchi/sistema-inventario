/* cargados */
/* En esta seccion tengo que mostrar los equipos cargados */
mostrarListado();


async function mostrarListado() {
    let losEquipos = [];
    const info = await fetch('equipos')
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

    /* let contador = 1; */
    equipos.forEach(dato => {
        let trow = document.createElement("tr");

        /* Llenamos los datos del ROW */
        for (let i = 0; i < 5; i++) {

            let td = document.createElement("td");

            if (i == 0) {
                td.innerHTML = String(dato["id"]);
            }
            if (i == 1) {
                td.innerHTML = String(dato["serie"]);
            }
            if (i == 2) {
                td.innerHTML = String(dato["tipo_equipo"]);
            }
            if (i == 3) {
                td.innerHTML = String(dato["servicio"]);
            }
            if (i == 4) {
                td.innerHTML =
                    `<a class="btn btn-danger btn-eliminar" id="${dato["id"]}">
                    <img src="imgs/trash-2-blanco.png" alt="">
                                </a>`;
            }
            trow.appendChild(td);
        }

        tabla.append(trow);
        /*  contador++; */
    });
    eventoBotones();
};

function eventoBotones() {
    let botones = document.getElementsByClassName("btn-eliminar");
 console.log(botones);
    for (const boton of botones) {
        let { id } = boton;
        console.log("id equipo elegido="+id)
        boton.onclick = () => { eliminarEquipo(id) };
    }
}

async function eliminarEquipo(id) {
    const resp = await fetch('equipos' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
}

/* fin cargados */