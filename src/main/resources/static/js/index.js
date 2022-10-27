eventoDescargarCsv();

//Con este código puedo ver en qué página me encuentro actualmente:
var paginaActual = window.location.pathname;
/* index */
/* Aca tengo recibir los datos y procesarlos en el BACK. */
if (paginaActual == "/index.html") {
    cargarListas();
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
        alert(datos.serie + " cargado con éxito!");
    }

    async function cargarListas() {
        /* Cargo las opciones para cada listado: */

        //Cliente:
        let clientes = await cargarInfo("clientes");

        if (clientes) {
            let menuCliente = document.getElementById("form-cliente");

            clientes.forEach(el => {
                let opti = document.createElement("option");
                opti.value = String(el[1]);
                opti.innerText = String(el[1]);
                menuCliente.append(opti);
            });
        } else {
            console.log("No hay clientes para cargar.");
        }

        //Tipo de equipo
        let tipoEquipos = await cargarInfo("tipoEquipos");

        if (tipoEquipos) {
            let menuTipoEquipos = document.getElementById("form-tipoequipo");

            tipoEquipos.forEach(el => {
                let opti = document.createElement("option");
                /* opti.value = String(el.nombre); */
                opti.value = String(el[1]);
                opti.innerText = String(el[1]);
                menuTipoEquipos.appendChild(opti);
            });
        } else {
            console.log("No hay tipos de equipos para cargar.");
        }

        //Marca
        let marcas = await cargarInfo("marcas");

        if (marcas) {
            let menuMarcas = document.getElementById("form-marca");

            marcas.forEach(el => {
                let opti = document.createElement("option");
                opti.value = String(el[1]);
                opti.innerText = String(el[1]);
                menuMarcas.appendChild(opti);
            });
        } else {
            console.log("No hay marcas para cargar.");
        }


        //Servicio
        let servicios = await cargarInfo("servicios");

        if (servicios) {
            let menuServicio = document.getElementById("form-servicio");

            servicios.forEach(el => {
                let opti = document.createElement("option");
                opti.value = String(el[1]);
                opti.innerText = String(el[1]);
                menuServicio.appendChild(opti);
            });
        } else {
            console.log("No hay servicios para cargar.");
        }

    }

    async function cargarInfo(tabla) {

        url = tabla;
        const res = await fetch(url, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        const data = res.json();
        return data;

    }
    /* Seccion imprimir */

    /* fin index */
}



/* listas */
/* En esta seccion tengo que subir las listas a la BD */
/* con esto determino que estoy en esta pagina y ejecuto su Js. */
if (paginaActual == "/listas.html") {
    eventoFormulario();
    eventoBotonBorrar();

    function eventoBotonBorrar() {
        let btnClientes = document.getElementById("borrarClientes");
        btnClientes.addEventListener("click", botonBorrarTabla);

        let btnMarcas = document.getElementById("borrarMarcas");
        btnMarcas.addEventListener("click", botonBorrarTabla);

        let btnServicios = document.getElementById("borrarServicios");
        btnServicios.addEventListener("click", botonBorrarTabla);

        let btnTipos = document.getElementById("borrarTipos");
        btnTipos.addEventListener("click", botonBorrarTabla);
    }

    function botonBorrarTabla(e) {
        e.preventDefault();
        let URL = "";

        if (e.target.id === "borrarClientes") {
            URL = "vaciar/clientes";
        }
        if (e.target.id === "borrarMarcas") {
            URL = "vaciar/marcas";
        }
        if (e.target.id === "borrarServicios") {
            URL = "vaciar/servicios";
        }
        if (e.target.id === "borrarTipos") {
            URL = "vaciar/tipo-equipos";
        }

        const vaciar = fetch(URL);
    }

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
        recargarPagina()
    }

    async function enviarListadoMarcas(e) {
        e.preventDefault();
        //Acá pregunto si se eligió archivo:
        let archivo = document.getElementById("input-marcas").files[0];

        leerData(archivo, "marcas");
        recargarPagina()
    }

    async function enviarListadoServicios(e) {
        e.preventDefault();
        //Acá pregunto si se eligió archivo:
        let archivo = document.getElementById("input-servicios").files[0];

        leerData(archivo, "servicios");
        recargarPagina()
    }

    async function enviarListadoTipos(e) {
        e.preventDefault();
        //Acá pregunto si se eligió archivo:
        let archivo = document.getElementById("input-tipos").files[0];

        leerData(archivo, "tipoEquipos");
        recargarPagina();
    }

    function leerData(archivo, queTabla) {
        const arrayColumnasNombre = [];
        if (archivo) {
            console.log("Entro a leer archivo en metodo leerData");
            let reader = new FileReader();
            reader.addEventListener('load', (evt) => {
                //Acá obtengo el archivo subido:
                let datos = evt.target.result;

                /* Aca tengo que trabajar con el archivo CSV.
                antes de enviar la info al server.*/
                //Este parametro de split es para abarcar todo tipo de salto de linea
                let lasLineas = datos.split(/[\r\n]+/gm);
                //Aca podría empezar el indice i = 1 para saltarme el encabezado
                //si lo tuviera el archivo csv
                for (let i = 0; i < lasLineas.length - 1; i++) {
                    let columna = lasLineas[i].split(";");
                    //elijo columna 0 porque se guarda el nombre, dato que me interesa
                    //si quiero otro cambio el indice de columna[].
                    let dato = String(columna[1]).replaceAll(`"`, '');//saco las comillas de los datos
                    //IF: para filtrar los campos vacíos
                    if (dato !== "") {
                        arrayColumnasNombre.push(dato);
                    }

                }

                /*  Todos los datos */
                for (let i = 0; i < arrayColumnasNombre.length; i++) {
                    let enviar = {};
                    enviar.nombre = String(arrayColumnasNombre[i]);
                    enviarDataServer(enviar, queTabla);
                }
            })

            reader.readAsText(archivo);
        } else {
            alert("No se ha seleccionado un archivo.");
            return;
        }
    }

    async function enviarDataServer(dato, tabla) {

        url = 'subirTablas/' + tabla;
        const variable = await fetch(url, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dato)
        });

    }
    function recargarPagina() {
        setTimeout(() => {
            location.reload();
        }, 8000);
    }
    /* fin listas */

}

function eventoDescargarCsv() {
    let btnDescarga = document.getElementById("descargarCsv");
    btnDescarga.addEventListener("click", solicitudDescarga);
    console.log("cargó evento descarga");
}
function solicitudDescarga(e) {
    e.preventDefault();
    window.location.assign("http://localhost:8080/descargarListado");
    /* const res = fetch("descargarListado");
    if (res) {
        console.log("envió fetch descarga");
    } */
}