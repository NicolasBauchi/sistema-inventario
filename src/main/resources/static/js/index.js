
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
var paginaActual = window.location.pathname;
/* index */
/* Aca tengo recibir los datos y procesarlos en el BACK. */
if (paginaActual == "/index.html") {
    eventoFormulario();
    /* Seccion registro de equipo */
    function eventoFormulario() {

        let miform = document.getElementById("form-ingreso-equipo");
        miform.addEventListener("submit", registrarEquipo);
    }

    async function registrarEquipo(e) {

        e.preventDefault();
        let datos = {};
        datos.cliente = document.getElementById("form-cliente").value;
        datos.propiedad = document.getElementById("form-propiedad").value;
        datos.serie = document.getElementById("form-nroserie").value;
        datos.tipo_equipo = document.getElementById("form-tipoequipo").value;
        datos.marca = document.getElementById("form-marca").value;
        datos.modelo = document.getElementById("form-modelo").value;
        datos.servicio = document.getElementById("form-servicio").value;
        datos.ubicacion = document.getElementById("form-ubicacion").value;

        const resp = await fetch('ingresar-equipo', {
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
}






/* listas */
/* En esta seccion tengo que subir las listas a la BD */
/* con esto determino que estoy en esta pagina y ejecuto su Js. */
if (paginaActual == "/listas.html") {
    eventoFormulario();

    function eventoFormulario() {

        let form_clientes = document.getElementById("form-subida-clientes");
        let form_marcas = document.getElementById("form-subida-marcas");
        let form_servicios = document.getElementById("form-subida-servicios");
        let form_tipos = document.getElementById("form-subida-tipos");

        form_clientes.addEventListener("submit", enviarListadoClientes);
        form_marcas.addEventListener("submit", enviarListadoMarcas);
        form_servicios.addEventListener("submit", enviarListadoServicios);
        form_tipos.addEventListener("submit", enviarListadoTipos);
    }

    function enviarListadoClientes(e) {
        e.preventDefault();
        //Acá pregunto si se eligió archivo:
        let archivo = document.getElementById("input-clientes").files[0];

        leerData(archivo, "clientes");

        /* location.reload(); */

    }

    async function enviarListadoMarcas(e) {
        e.preventDefault();
        //Acá pregunto si se eligió archivo:
        let archivo = document.getElementById("input-marcas").files[0];

        leerData(archivo, "marcas");

        /* location.reload(); */
    }

    async function enviarListadoServicios(e) {
        e.preventDefault();
        //Acá pregunto si se eligió archivo:
        let archivo = document.getElementById("input-servicios").files[0];

        leerData(archivo, "servicios");

        /* location.reload(); */
    }

    async function enviarListadoTipos(e) {
        e.preventDefault();
        //Acá pregunto si se eligió archivo:
        let archivo = document.getElementById("input-tipos").files[0];
        
        leerData(archivo, "tipoEquipos");

        /* location.reload(); */
    }

    function leerData(archivo, queTabla) {
        const arrayColumnasNombre = [];
        if (archivo) {
            let reader = new FileReader();
            reader.addEventListener('load', (evt) => {
                //Acá obtengo el archivo subido:
                let datos = evt.target.result;

                /* Aca tengo que trabajar con el archivo CSV.
                antes de enviar la info al server.*/
                let lasLíneas = datos.split("\r\n");
                //Aca podría empezar el indice i = 1 para saltarme el encabezado
                //si lo tuviera el archivo csv
                for (let i = 0; i < lasLíneas.length - 1; i++) {
                    let columna = lasLíneas[i].split(";");
                    //elijo columna 0 porque se guarda el nombre, dato que me interesa
                    //si quiero otro cambio el indice de columna[].
                    let dato = String(columna[0]);
                    arrayColumnasNombre.push(dato);
                }


                let enviar = {};
                enviar.nombre = String(arrayColumnasNombre[0]);

                enviarDataServer(enviar, queTabla);
                
            })

            reader.readAsText(archivo);
        } else {
            alert("No se ha seleccionado un archivo.");
            return;
        }
    }

    async function enviarDataServer(dato, tabla) {
        console.log("Datos antes de ser enviados por fetch: ");
        console.log("Dato");
        console.log(dato);
        console.log("Tabla:");
        console.log(tabla);
        url = 'subirTablas/' + tabla;
        const variable = await fetch(url, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dato)
        });
        console.log(variable);
    }
    /* fin listas */

}
