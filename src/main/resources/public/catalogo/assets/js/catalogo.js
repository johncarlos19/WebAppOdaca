
function modeloList(obj){
    $("#listadoModelo").empty()
    var modelo = []
    for(var key in obj){
        var url = '<li><a class="selectbox-link0" href="#" style="font-family: Montserrat, sans-serif;font-size: 24PX;"><strong>'+obj[key].modelo+'</strong><span>&nbsp;EXCLUSIVO</span></a></li>'
        $("#listadoModelo").prepend(url)
    }
    const selectBox = new SelectBox(".selectbox-title0",".selectbox-link0",".selectbox-result0",".accordion-select0","0");
    const selectBox1 = new SelectBox(".selectbox-title1",".selectbox-link1",".selectbox-result1",".accordion-select1","1");


}

function productoactionList(obj,action){
    switch (action) {
        case 'destacado':



            $("#destacado").empty()
            var cant = obj.length

            if (cant>=5){

            }else {

                var newcant = 5 - cant
                for (i = 0; i < newcant; i++) {
                    $("#destacado").prepend('                            <div class="justify-content-center spacer-slider">\n' +
                        '                                <figure class="figure">' +
                        '<img class="img-fluid figure-img" src="../catalogo/assets/img/5ba289e09f24ea6d65fc8a70_noimage.jpg" style="width: 216px;height: 224px" >\n' +
                        '                                </figure>\n' +
                        '                            </div>')

                }
            }

            for(var key in obj){

                var img = obj[key].foto.fotoBase64

                if (img!== null){

                }else {
                    img = '../catalogo/assets/img/moto02.png'
                }

                var url = '                            <div class="justify-content-center spacer-slider">\n' +
                    '                                <figure class="figure"><img class="" href="#" data-modal-id="bs4_sldr_cmrce" data-toggle="modal" onclick="getProducto(&apos;'+obj[key].codigo+'&apos;)"  class=" bs4_modal_trigger img-fluid figure-img" src="'+img+'" style="width: 216px;height: 224px" alt="No Found">\n' +


                    '                        <figcaption class="figure-caption">\n' +
                    '                            <a  ><span class="bs4_modal_trigger" href="#" data-modal-id="bs4_sldr_cmrce" data-toggle="modal" onclick="getProducto(&apos;'+obj[key].codigo+'&apos;)" >'+obj[key].nombre+'</span></a>\n' +
                    '\n' +
                    '\n' +
                    '\n' +
                    '                        </figcaption>'
                '                                </figure>\n' +
                '                            </div>'
                $("#destacado").prepend(url)
            }
            dest = true
            reloadSlider()





            break;
        case 'nuevo':
            $("#productonuevo").empty()
            var cant = obj.length

            if (cant>=5){

            }else {

                var newcant = 5 - cant
                for (i = 0; i < newcant; i++) {
                    $("#productonuevo").prepend('                            <div class="justify-content-center spacer-slider">\n' +
                        '                                <figure class="figure">' +
                        '<img class="img-fluid figure-img" src="../catalogo/assets/img/5ba289e09f24ea6d65fc8a70_noimage.jpg" style="width: 216px;height: 224px" >\n' +
                        '                                </figure>\n' +
                        '                            </div>')

                }
            }

            for(var key in obj){

                var img = obj[key].foto.fotoBase64

                if (img!== null){

                }else {
                    img = '../catalogo/assets/img/moto02.png'
                }

                var url = '                            <div class="justify-content-center spacer-slider">\n' +
                    '                                <figure class="figure"><img data-modal-id="bs4_sldr_cmrce" data-toggle="modal" onclick="getProducto(&apos;'+obj[key].codigo+'&apos;)" class=" bs4_modal_trigger img-fluid figure-img" src="'+img+'" style="width: 216px;height: 224px" alt="No Found">\n' +


                    '                        <figcaption class="figure-caption">\n' +
                    '                            <a ><span class="bs4_modal_trigger" href="#" data-modal-id="bs4_sldr_cmrce" data-toggle="modal" onclick="getProducto(&apos;'+obj[key].codigo+'&apos;)" >'+obj[key].nombre+'</span></a>\n' +
                    '\n' +
                    '\n' +
                    '\n' +
                    '                        </figcaption>'
                '                                </figure>\n' +
                '                            </div>'
                $("#productonuevo").prepend(url)
            }

            nue = true;
            reloadSlider()


            break;
        case 'oferta':
            $("#ofertasemana").empty()
            var cant = obj.length

            if (cant>=5){

            }else {

                var newcant = 5 - cant
                for (i = 0; i < newcant; i++) {
                    $("#ofertasemana").prepend('                            <div class="justify-content-center spacer-slider">\n' +
                        '                                <figure class="figure">' +
                        '<img class="img-fluid figure-img" src="../catalogo/assets/img/5ba289e09f24ea6d65fc8a70_noimage.jpg" style="width: 216px;height: 224px" >\n' +
                        '                                </figure>\n' +
                        '                            </div>')

                }
            }

            for(var key in obj){

                var img = obj[key].foto.fotoBase64

                if (img!== null){

                }else {
                    img = '../catalogo/assets/img/moto02.png'
                }

                var url = '                            <div class="justify-content-center spacer-slider">\n' +
                    '                                <figure class="figure"><img data-modal-id="bs4_sldr_cmrce" data-toggle="modal" onclick="getProducto(&apos;'+obj[key].codigo+'&apos;)" class="bs4_modal_trigger img-fluid figure-img" src="'+img+'" style="width: 216px;height: 224px" alt="No Found">\n' +


                    '                        <figcaption class="figure-caption">\n' +
                    '                            <a ><span class="bs4_modal_trigger" href="#" data-modal-id="bs4_sldr_cmrce" data-toggle="modal" onclick="getProducto(&apos;'+obj[key].codigo+'&apos;)" >'+obj[key].nombre+'</span></a>\n' +
                    '\n' +
                    '\n' +
                    '\n' +
                    '                        </figcaption>'
                '                                </figure>\n' +
                '                            </div>'
                $("#ofertasemana").prepend(url)
            }
            oft = true
            reloadSlider()



            break;
        case 'vendpop':
            $("#masvendido").empty()
            var cant = obj.length
            if (cant>=5){

            }else {

                var newcant = 5 - cant
                for (i = 0; i < newcant; i++) {
                    $("#masvendido").prepend('                            <div class="justify-content-center spacer-slider">\n' +
                        '                                <figure class="figure">' +
                        '<img class="img-fluid figure-img" src="../catalogo/assets/img/5ba289e09f24ea6d65fc8a70_noimage.jpg" style="width: 216px;height: 224px">\n' +
                        '                                </figure>\n' +
                        '                            </div>')

                }
            }

            for(var key in obj){

                var img = obj[key].foto.fotoBase64

                if (img!== null){

                }else {
                    img = '../catalogo/assets/img/moto02.png'
                }

                var url = '                            <div class="justify-content-center spacer-slider">\n' +
                    '                                <figure class="figure"><img data-modal-id="bs4_sldr_cmrce" data-toggle="modal" onclick="getProducto(&apos;'+obj[key].codigo+'&apos;)" class="img-fluid figure-img bs4_modal_trigger" src="'+img+'" style="width: 216px;height: 224px" alt="No Found">\n' +


                    '                        <figcaption class="figure-caption">\n' +
                    '                            <a ><span class="bs4_modal_trigger" href="#" data-modal-id="bs4_sldr_cmrce" data-toggle="modal" onclick="getProducto(&apos;'+obj[key].codigo+'&apos;)" >'+obj[key].nombre+'</span></a>\n' +
                    '\n' +
                    '\n' +
                    '\n' +
                    '                        </figcaption>'
                '                                </figure>\n' +
                '                            </div>'
                $("#masvendido").prepend(url)
            }

            pop = true;
            reloadSlider()



            break;





        // $('#destacado').slick.refresh()
        // $('.multiple-item-slider')[1].slick.refresh()
        // $('.multiple-item-slider')[2].slick.refresh()
        // $('.multiple-item-slider')[3].slick.refresh()

    }
}


function inventarioList(obj){

    var lis = [];
    while(lis.length > 0) {
        lis.pop();
    }

    $('#datatable2').DataTable().clear().destroy();
    $('#datatable2').DataTable({
        "deferRender": true,
        "retrieve": true,
        "processing": true,
        "order": [[ 1, "asc" ]],

        "language": {

            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }},
        // "data": lis,
        "order": [[ 2, "asc" ]],
        "columns":[
            {"data": "Imagen"},
            {"data": "Codigo"},
            {"data": "Descripcion"},
            {"data": "Referencia"},
            {"data": "Marca"},
            {"data": "Modelos"},
            {"data": "Disponible"}]


    });
    for(var key in obj) {

        var img = obj[key].fotoOri.fotoBase64
        var modeloss = ''
        if (img == null){
            img = "../catalogo/assets/img/moto02.png"
        }

        var disp = 'No disponible'
        if(obj[key].disponible ===true){
            disp = 'Disponible'
        }
        for(var model in obj[key].modelos){
            modeloss += '<br>\n' +
                '                                                        <a>'+obj[key].modelos[model].modelo+'</a>'

        }
        var employee = {

            "Imagen":   "<img src='"+img+"' width='350' height='350' >",
            "Codigo":    obj[key].codigo,
            "Descripcion":   obj[key].nombre,
            "Referencia": obj[key].referencia,
            "Marca":  obj[key].marca,
            "Modelos":     modeloss,
            "Disponible":   disp
        }

        console.log(JSON.stringify(employee))
        // c = [];
        // c.push(obj[key].id);
        // c.push(obj[key].nombre);
        // c.push(obj[key].descripcion);
        // c.push(obj[key].disponible);
        // c.push(obj[key].stock);
        // c.push(obj[key].precioVenta);
        // c.push(obj[key].precioCompra);
        $('#datatable2').DataTable().row.add( employee ).draw();
        lis.push(employee);
        // agregarProductoDB(obj[key]);
    };




    // worker.postMessage({'cmd': 'getmodelolist'});

    var marca = getUrlParameter("marca")
    var modelo = getUrlParameter("modelo")
    var buildString = ""
    if (marca!= null){
        buildString = buildString + marca
    }
    if (marca!= null && modelo!= null ){
        buildString = buildString + " " + modelo
    }
    if (marca== null && modelo!= null ){
        buildString = buildString +  modelo
    }
    $('#datatable2').DataTable().search(buildString).draw();
}

function getProductoComplete(obj,action){
    switch (action){
        case 'getProducto':
            $("#modelo").empty()
            try {
                for(var key in obj.modelos){
                    $("#modelo").prepend('<p class="text-right">'+obj.modelos[key].modelo+'</p>')
                }
            }catch (e) {
                console.log("No hay modelos")
            }


            var imgpri = '<img src="'+obj.fotoOri.fotoBase64+'" alt="bs4_slider_commerce_01">'
            var imgsec = '<img src="'+obj.foto.fotoBase64+'" alt="bs4_slider_commerce_01">'
            document.getElementById('titulo').innerText=obj.nombre
            document.getElementById('referencia').innerText=obj.referencia
            document.getElementById('marca').innerText=obj.marca
            document.getElementById('codigoProducto').innerText=obj.codigo
            document.getElementById('fotoprin').innerHTML= imgpri
            document.getElementById('fotosec').innerHTML= imgsec

            if(obj.disponible === true){
                document.getElementById('disponible').innerText='Disponible'
            }else {
                document.getElementById('disponible').innerText='No Disponible'
            }
            break;
        case 'getProductoSaveList':

            var contador = obj.lenght;
            var count = 0;
            try {
                limpiarProductoDB()
            }catch (e){
                console.log("No hay nada en la DB")
            }

            // $('#progreso').html("                        <div class='progress'>\n" +
            //     "                            <div class='progress-bar' role='progressbar' id='linebar' style='width: 0%;' aria-valuenow='0' aria-valuemin='0' aria-valuemax='100'>0%</div>\n"+
            //     "                       </div>;")
            for(var key in obj){
                agregarProductoDB(obj[key])
                count++;
                var total = count/contador;
                $('#linebar').css("width", total+'%');
                $('#linebar').html(total+'%');
            }

            $('#progreso').html("");

            alert("Datos sincronizados");

            break;
        default:
            break;
    }
}
