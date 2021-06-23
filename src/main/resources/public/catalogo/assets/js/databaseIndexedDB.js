//dependiendo el navegador busco la referencia del objeto.
var indexedDB = window.indexedDB || window.mozIndexedDB || window.webkitIndexedDB || window.msIndexedDB

//indicamos el nombre y la versión
var dataBase = indexedDB.open("odaca", 1);

var impListadoModelo = false;

var impListadoAction = false;

var impListadoProducto = false;

var validate = false;

//se ejecuta la primera vez que se crea la estructura
//o se cambia la versión de la base de datos.
dataBase.onupgradeneeded = function (e) {
    console.log("Creando la estructura de la tabla");

    //obteniendo la conexión activa
    active = dataBase.result;

    //creando la colección:
    //En este caso, la colección, tendrá un ID autogenerado.

    var usuario = active.createObjectStore("usuario", {keyPath: 'user', autoIncrement: false});
    //creando los indices. (Dado por el nombre, campo y opciones)
    usuario.createIndex('por_user', 'user', {unique: true});

    var producto = active.createObjectStore("producto", { keyPath : 'codigo', autoIncrement : false });
    //creando los indices. (Dado por el nombre, campo y opciones)
    producto.createIndex('por_codigo', 'codigo', {unique: true});

    var productoNuevo = active.createObjectStore("nuevo", { keyPath : 'id', autoIncrement : true });
    //creando los indices. (Dado por el nombre, campo y opciones)
    productoNuevo.createIndex('por_id', 'id', {unique: true});

    var oferta = active.createObjectStore("oferta", { keyPath : 'id', autoIncrement : true });
    //creando los indices. (Dado por el nombre, campo y opciones)
    oferta.createIndex('por_id', 'id', {unique: true});

    var vendpop = active.createObjectStore("vendpop", { keyPath : 'id', autoIncrement : true });
    //creando los indices. (Dado por el nombre, campo y opciones)
    vendpop.createIndex('por_id', 'id', {unique: true});

    var destacado = active.createObjectStore("destacado", { keyPath : 'id', autoIncrement : true });
    //creando los indices. (Dado por el nombre, campo y opciones)
    destacado.createIndex('por_id', 'id', {unique: true});

    var modelo = active.createObjectStore("modelo", { keyPath : 'id', autoIncrement : true });
    //creando los indices. (Dado por el nombre, campo y opciones)
    modelo.createIndex('por_id', 'id', {unique: true});


};

//El evento que se dispara una vez, lo
dataBase.onsuccess = function (e) {
    console.log('Proceso ejecutado de forma correctamente');
    if (impListadoModelo===true){
        listarModeloDB( "impPrin");
    }
    if (impListadoProducto===true){
        listarProductoDB( "impPrin");
    }
    if (impListadoAction===true){
        listarActionDB( "impPrin","destacado");
        listarActionDB( "impPrin","nuevo");
        listarActionDB( "impPrin","oferta");
        listarActionDB( "impPrin","vendpop");
    }

    if (validate===true){
        var userr = document.getElementById("user").value
        borrarUsuario(userr)
    }
};

dataBase.onerror = function (e) {
    console.error('Error en el proceso: ' + e.target.errorCode);
};




function agregarProductoDB(Product) {
    var dbActiva = dataBase.result; //Nos retorna una referencia al IDBDatabase.

    //Para realizar una operación de agreagr, actualización o borrar.
    // Es necesario abrir una transacción e indicar un modo: readonly, readwrite y versionchange
    var transaccion = dbActiva.transaction(["producto"], "readwrite");


    //abriendo la colección de datos que estaremos usando.
    var producto = transaccion.objectStore("producto");

    //Para agregar se puede usar add o put, el add requiere que no exista
    // el objeto.
    var request = producto.put(Product);

    request.onerror = function (e) {
        var mensaje = "Error: " + e.target.errorCode;
        console.error(mensaje);
        alert(mensaje)
    };

    request.onsuccess = function (e) {
        console.log("Datos Procesado con exito");
    };


}
function agregarModeloDB(model) {
    var dbActiva = dataBase.result; //Nos retorna una referencia al IDBDatabase.

    //Para realizar una operación de agreagr, actualización o borrar.
    // Es necesario abrir una transacción e indicar un modo: readonly, readwrite y versionchange
    var transaccion = dbActiva.transaction(["modelo"], "readwrite");


    //abriendo la colección de datos que estaremos usando.
    var modelo = transaccion.objectStore("modelo");

    //Para agregar se puede usar add o put, el add requiere que no exista
    // el objeto.
    var request = modelo.put(model);

    request.onerror = function (e) {
        var mensaje = "Error: " + e.target.errorCode;
        console.error(mensaje);
        alert(mensaje)
    };

    request.onsuccess = function (e) {
        console.log("Datos Procesado con exito");
    };


}

function limpiarProductoDB(){
    var data = dataBase.result.transaction(["producto"], "readwrite");
    var producto = data.objectStore("producto");


    var borrar = producto.clear();

    producto.onsuccess = function (event) {
        console.log("producto borrados de la IndexedDB.");
    };
}

function limpiarUsuarioDB(){
    var data = dataBase.result.transaction(["usuario"], "readwrite");
    var usuario = data.objectStore("usuario");


    var borrar = usuario.clear();

    producto.onsuccess = function (event) {
        console.log("usuario borrados de la IndexedDB.");
    };
}

function limpiarModelosDB(){
    var data = dataBase.result.transaction(["modelo"], "readwrite");
    var modelo = data.objectStore("modelo");


    var borrar = modelo.clear();

    modelo.onsuccess = function (event) {
        console.log("producto borrados de la IndexedDB.");
    };
}
function limpiarActionDB(action){
    var data = dataBase.result.transaction([""+action], "readwrite");
    var actiondoit = data.objectStore(""+action);


    var borrar = actiondoit.clear();

    actiondoit.onsuccess = function (event) {
        console.log("action borrados de la IndexedDB.");
    };
}

function buscarProductoDB(aux, posi) {
    //recuperando la matricula.
    var user = aux;
    console.log("user digitada: " + aux);

    //abriendo la transacción en modo readonly.
    var data = dataBase.result.transaction(["producto"]);
    var producto = data.objectStore("producto");

    //buscando producto por la referencia al key.
    var request = producto.get("" + aux);
        request.onsuccess = function (e) {

        var resultado = e.target.result;
        console.log("los datos: " + resultado);
        var form = document.getElementById("login")

        if (resultado !== undefined) {
            // var myHeaders = new Headers();

            console.log(JSON.stringify(resultado));
            // myHeaders.append('usuario', "" + resultado.user);
            switch (posi){
                case "impPrin":
                    getProductoComplete(resultado,"getProducto");
                    break;
                default:
                    break;
            }


            // if (resultado.user === document.querySelector("#user").value && resultado.password === document.querySelector("#password").value) {
            //     if (navigator.onLine === false){
            //         window.location.href = "/home";
            //     }else{
            //         form.submit();
            //     }
            //
            // } else {
            //     // form.submit();
            // }

        } else {
            console.log("Producto no encontrado...");
            worker.postMessage({'cmd': 'getProducto', 'id': aux});

            // form.submit();
        }
    };
    request.onerror = function (e) {
        var mensaje = "Error: " + e.target.errorCode;
        console.error(mensaje);
        alert(mensaje)
        // worker.postMessage({'cmd': 'getProducto', 'id': aux});
    };

}

function listarModeloDB(posi) {


    //por defecto si no lo indico el tipo de transacción será readonly
    var data = dataBase.result.transaction(["modelo"]);
    var modelo = data.objectStore("modelo");
    var contador = 0;
    var modelo_recuperados=[];

    //abriendo el cursor.
    modelo.openCursor().onsuccess=function(e) {
        //recuperando la posicion del cursor
        var cursor = e.target.result;
        if(cursor){
            contador++;
            //recuperando el objeto.
            modelo_recuperados.push(cursor.value);
            console.log(JSON.stringify(cursor.value));

            //Función que permite seguir recorriendo el cursor.
            cursor.continue();

        }else {
            console.log("La cantidad de registros recuperados es: "+modelo_recuperados.length);
        }
    };

    //Una vez que se realiza la operación llamo la impresión.
    data.oncomplete = function () {
        switch (posi){
            case "impPrin":
                if(modelo_recuperados.length !== 0){
                    modeloList(modelo_recuperados);
                }else{
                    worker.postMessage({'cmd': 'getmodelolist'});
                }
                break;
            default:
                break;
        }
    }


    data.onerror = function (e) {
        var mensaje = "Error: " + e.target.errorCode;
        console.error(mensaje);
        alert(mensaje)
        // worker.postMessage({'cmd': 'getProducto', 'id': aux});
    };

}

function listarActionDB(posi,action) {


    //por defecto si no lo indico el tipo de transacción será readonly
    var data = dataBase.result.transaction([""+action]);
    var actiondoit = data.objectStore(""+action);
    var contador = 0;
    var action_recuperados=[];

    //abriendo el cursor.
    actiondoit.openCursor().onsuccess=function(e) {
        //recuperando la posicion del cursor
        var cursor = e.target.result;
        if(cursor){
            contador++;
            //recuperando el objeto.
            action_recuperados.push(cursor.value);
            console.log(JSON.stringify(cursor.value));

            //Función que permite seguir recorriendo el cursor.
            cursor.continue();

        }else {
            console.log("La cantidad de registros recuperados es: "+action_recuperados.length);
        }
    };

    //Una vez que se realiza la operación llamo la impresión.
    data.oncomplete = function () {
        switch (posi){
            case "impPrin":
                if(action_recuperados.length !== 0){
                    productoactionList(action_recuperados,action);
                }else{
                    worker.postMessage({'cmd': 'getactionProducto', 'action': action});
                }
                break;
            default:
                break;
        }
    }


    data.onerror = function (e) {
        var mensaje = "Error: " + e.target.errorCode;
        console.error(mensaje);
        alert(mensaje)
        // worker.postMessage({'cmd': 'getProducto', 'id': aux});
    };

}



function agregarProductoActionDB(Product,action) {
    var dbActiva = dataBase.result; //Nos retorna una referencia al IDBDatabase.

    //Para realizar una operación de agreagr, actualización o borrar.
    // Es necesario abrir una transacción e indicar un modo: readonly, readwrite y versionchange
    var transaccion = dbActiva.transaction([""+action], "readwrite");


    //abriendo la colección de datos que estaremos usando.
    var producto = transaccion.objectStore(""+action);

    //Para agregar se puede usar add o put, el add requiere que no exista
    // el objeto.
    var request = producto.put(Product);

    request.onerror = function (e) {
        var mensaje = "Error: " + e.target.errorCode;
        console.error(mensaje);
        alert(mensaje)
    };

    request.onsuccess = function (e) {
        console.log("Datos Procesado con exito");
    };


}


function listarProductoDB(posi) {
    //por defecto si no lo indico el tipo de transacción será readonly
    var data = dataBase.result.transaction(["producto"]);
    var producto = data.objectStore("producto");
    var contador = 0;
    var producto_recuperados=[];

    //abriendo el cursor.
    producto.openCursor().onsuccess=function(e) {
        //recuperando la posicion del cursor
        var cursor = e.target.result;
        if(cursor){
            contador++;
            //recuperando el objeto.
            producto_recuperados.push(cursor.value);
            // console.log(JSON.stringify(cursor.value));

            //Función que permite seguir recorriendo el cursor.
            cursor.continue();

        }else {
            console.log("La cantidad de registros recuperados es: "+producto_recuperados.length);
        }
    };

    //Una vez que se realiza la operación llamo la impresión.
    data.oncomplete = function () {
        switch (posi){
            case "impPrin":
                if(producto_recuperados.length !== 0){
                    inventarioList(producto_recuperados);
                }else{
                    worker.postMessage({'cmd': 'getinventarioList'});
                }
                break;
            default:
                break;
        }
        // return producto_recuperados;
    }
}




function agregarUsuarioValido(aux) {
    var dbActiva = dataBase.result; //Nos retorna una referencia al IDBDatabase.

    //Para realizar una operación de agreagr, actualización o borrar.
    // Es necesario abrir una transacción e indicar un modo: readonly, readwrite y versionchange
    var transaccion = dbActiva.transaction(["usuario"], "readwrite");

    //Manejando los errores.
    transaccion.onerror = function (e) {
        alert(request.error.name + '\n\n' + request.error.message);
    };

    transaccion.oncomplete = function (e) {
        // document.querySelector("#user").value = '';

    };

    //abriendo la colección de datos que estaremos usando.
    var usuario = transaccion.objectStore("usuario");


    //buscando estudiante por la referencia al key.
    usuario.get(""+aux.user).onsuccess = function(e) {

        var resultado = e.target.result;
        console.log("los datos: "+JSON.stringify(resultado));

        if(resultado !== undefined){

            resultado.iddevice = aux.iddevice;
            resultado.password = aux.password;
            resultado.validate = aux.validate;

            var solicitudUpdate = usuario.put(resultado);

            //eventos.
            solicitudUpdate.onsuccess = function (e) {
                setTimeout(function(){ document.getElementById("cambiarPassowrd").submit() }, 1000);
                console.log("Datos Actualizados....");
            }

            solicitudUpdate.onerror = function (e) {
                console.error("Error Datos Actualizados....");
            }

        }else{
            console.log("Estudiante no encontrado...");
            var request = usuario.put(aux);

            request.onerror = function (e) {
                var mensaje = "Error: " + e.target.errorCode;
                console.error(mensaje);
                alert(mensaje)
            };

            request.onsuccess = function (e) {
                setTimeout(function(){ document.getElementById("cambiarPassowrd").submit() }, 1000);
                console.log("Datos Procesado con exito");
            };
        }
    };

    //Para agregar se puede usar add o put, el add requiere que no exista
    // el objeto.





}


function borrarUsuario(user) {



    var data = dataBase.result.transaction(["usuario"], "readwrite");
    var usuario = data.objectStore("usuario");

    usuario.delete(user).onsuccess = function (e) {
        console.log("Usuario eliminado...");
    };
}

function buscarUsuarioValidar() {
    //recuperando la matricula.
    var user = document.querySelector("#user").value;
    console.log("user digitada: " + user);

    //abriendo la transacción en modo readonly.
    var data = dataBase.result.transaction(["usuario"]);
    var usuario = data.objectStore("usuario");

    //buscando estudiante por la referencia al key.
    usuario.get("" + user).onsuccess = function (e) {

        var resultado = e.target.result;
        console.log("los datos: " + resultado);
        var form = document.getElementById("login")

        if (resultado !== undefined) {
            var myHeaders = new Headers();




            // console.log(JSON.stringify(resultado));
            // myHeaders.append('usuario', "" + resultado.user);
            // if (resultado.user === document.querySelector("#user").value && resultado.password === document.querySelector("#password").value) {
            //     if (navigator.onLine === false){
            //         window.location.href = "/catalogo/home";
            //     }else{
            //         form.submit();
            //     }
            //
            // } else {
            //     form.submit();
            // }

        } else {
            console.log("Usuario no encontrado...");

            // form.submit();
        }
    };

}


function editarUsuario() {

    //recuperando la matricula.
    var matricula = prompt("Indique la matrícula");
    console.log("matricula digitada: "+matricula);

    var nombre = prompt("Indique el nombre");
    console.log("el nombre digitada: "+nombre);

    //abriendo la transacción en modo escritura.
    var data = dataBase.result.transaction(["estudiantes"],"readwrite");
    var estudiantes = data.objectStore("estudiantes");

    //buscando estudiante por la referencia al key.
    estudiantes.get(""+matricula).onsuccess = function(e) {

        var resultado = e.target.result;
        console.log("los datos: "+JSON.stringify(resultado));

        if(resultado !== undefined){

            resultado.nombre = nombre;

            var solicitudUpdate = estudiantes.put(resultado);

            //eventos.
            solicitudUpdate.onsuccess = function (e) {
                console.log("Datos Actualizados....");
            }

            solicitudUpdate.onerror = function (e) {
                console.error("Error Datos Actualizados....");
            }

        }else{
            console.log("Estudiante no encontrado...");
        }
    };


}


function buscarUsuario() {
    //recuperando la matricula.
    var user = document.querySelector("#user").value;
    console.log("user digitada: " + user);

    //abriendo la transacción en modo readonly.
    var data = dataBase.result.transaction(["usuario"]);
    var usuario = data.objectStore("usuario");

    //buscando estudiante por la referencia al key.
    usuario.get("" + user).onsuccess = function (e) {

        var resultado = e.target.result;
        console.log("los datos: " + resultado);
        var form = document.getElementById("login")

        if (resultado !== undefined) {
            var myHeaders = new Headers();

            console.log(JSON.stringify(resultado));
            myHeaders.append('usuario', "" + resultado.user);
            if (resultado.user === document.querySelector("#user").value && resultado.password === document.querySelector("#password").value) {
                if (navigator.onLine === false){
                    window.location.href = "/catalogo/home";
                }else{
                    var DOB = document.createElement("input");
                    DOB.setAttribute("type", "text");
                    DOB.setAttribute("name", "iddevice");
                    DOB.setAttribute("value", resultado.iddevice);
                    form.appendChild(DOB)
                    form.submit();
                }

            } else {
                var DOB = document.createElement("input");
                DOB.setAttribute("type", "text");
                DOB.setAttribute("name", "iddevice");
                DOB.setAttribute("value", resultado.iddevice);
                form.appendChild(DOB)
                form.submit();
            }

        } else {
            console.log("Usuario no encontrado...");

            form.submit();
        }
    };

}