const worker = new Worker('../js/webworker-ajax.js');
var tablaUsuarios;
const kk = [];

var dest = false;
var pop = false;
var nue = false;
var oft = false;




worker.onmessage = function (e) { //recuperando la información
    if(e.data.cmd === 'respuesta'){
        // while(kk.length > 0) {
        //     kk.pop();
        // }
        //
        // var obj = e.data.data;
        // for(var key in obj) {
        //     var sto
        //     if(obj[key].stock === 0){
        //         sto = "<button class='btn btn-default'>"+obj[key].stock+"</button>"
        //     }else if(obj[key].stock<=10){
        //         sto = "<button class='btn btn-danger'>"+obj[key].stock+"</button>"
        //     }else if(obj[key].stock<=15){
        //         sto = "<button class='btn btn-warning'>"+obj[key].stock+"</button>"
        //     }else{
        //         sto = "<button class='btn btn-success'>"+obj[key].stock+"</button>"
        //     }
        //     var img = obj[key].fotoBase64
        //     if (img == null){
        //         img = "../dashboardPlantilla/img/productos/default/anonymous.png"
        //     }
        //     var accionn = "<div class='btn-group' style = ' "+document.getElementById("inventa").value+"'> " +
        //         // " <form method='post' action='/dashboard/showProducto'><input type='hidden' name='idProducto' value='"+obj[key].id+"'><button class='btn btn-warning btnEditarProducto' type='button' ><i  class='fa fa-eye'></i></button></form>" +
        //         " <button class='btn btn-warning btnEditarProducto' type='button' idProducto='"+obj[key].id+"' ><i  class='fa fa-eye'></i></button>"
        //
        //     if (obj[key].cantProductoVendido ===0){
        //         accionn += "   <button class='btn btn-danger btnEliminarProducto' idproducto='"+obj[key].id+"'  codigo='118'  imagen='vistas/img/productos/default/anonymous.png'><i  class='fa fa-times'></i></button> </div>"
        //     }else{
        //         accionn +="   </div>"
        //     }
        //
        //     var employee = {
        //         "#":    obj[key].id,
        //         "Imagen":   "<img src='"+img+"' width='64' height='64' >",
        //         "Nombre":   obj[key].nombre,
        //         "Codigo": obj[key].codigo_local,
        //         "Descripcion":  obj[key].descripcion,
        //         "Categoria":     obj[key].categorias,
        //         "Precio de compra":   (Math.round(obj[key].precioCompra * 100) / 100).toFixed(2),
        //         "Precio de venta":     (Math.round(obj[key].precioVenta * 100) / 100).toFixed(2),
        //         "Precio de lista":     (Math.round(obj[key].precioLista * 100) / 100).toFixed(2),
        //         "Stock":     sto,
        //         "Disponible":     obj[key].disponible,
        //         "Acciones":     accionn
        //     }
        //
        //     // c = [];
        //     // c.push(obj[key].id);
        //     // c.push(obj[key].nombre);
        //     // c.push(obj[key].descripcion);
        //     // c.push(obj[key].disponible);
        //     // c.push(obj[key].stock);
        //     // c.push(obj[key].precioVenta);
        //     // c.push(obj[key].precioCompra);
        //     kk.push(employee);
        // };
        //
        // console.log("valorr"+JSON.stringify(kk))
        //
        // $('.tablaProductos').DataTable().clear().destroy();
        // // $('.tablaProductos tfoot th').each( function () {
        // //     var title = $(this).text();
        // //     if (title === "Imagen" || title === "Acciones"){
        // //
        // //     }else{
        // //         $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
        // //     }
        // // } );
        //
        //
        //
        // $('.tablaProductos').DataTable( {
        //     // "ajax": "ajax/datatable-productos.ajax.php?perfilOculto="+perfilOculto,
        //
        //     "deferRender": true,
        //     "retrieve": true,
        //     "processing": true,
        //
        //     "language": {
        //
        //         "sProcessing":     "Procesando...",
        //         "sLengthMenu":     "Mostrar _MENU_ registros",
        //         "sZeroRecords":    "No se encontraron resultados",
        //         "sEmptyTable":     "Ningún dato disponible en esta tabla",
        //         "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
        //         "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0",
        //         "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
        //         "sInfoPostFix":    "",
        //         "sSearch":         "Buscar:",
        //         "sUrl":            "",
        //         "sInfoThousands":  ",",
        //         "sLoadingRecords": "Cargando...",
        //         "oPaginate": {
        //             "sFirst":    "Primero",
        //             "sLast":     "Último",
        //             "sNext":     "Siguiente",
        //             "sPrevious": "Anterior"
        //         },
        //         "oAria": {
        //             "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
        //             "sSortDescending": ": Activar para ordenar la columna de manera descendente"
        //         }
        //
        //     },
        //     "data": kk
        //     ,
        //     "columns":[
        //         {"data": "#"},
        //         {"data": "Imagen"},
        //         {"data": "Nombre"},
        //         {"data": "Codigo"},
        //         {"data": "Descripcion"},
        //         {"data": "Categoria"},
        //         {"data": "Precio de compra"},
        //         {"data": "Precio de venta"},
        //         {"data": "Precio de lista"},
        //         {"data": "Stock"},
        //         {"data": "Disponible"},
        //         {"data": "Acciones"}
        //     ]
        //     // ,initComplete: function () {
        //     //     this.api().columns().every( function () {
        //     //         var column = this;
        //     //         // $(column.hea)
        //     //
        //     //         var select = $('<select><option value=""></option></select>')
        //     //             .appendTo(  $(".tablaProductos thead tr:eq(1) th").eq(column.index()).empty()  )
        //     //             .on( 'change', function () {
        //     //                 var val = $.fn.dataTable.util.escapeRegex(
        //     //                     $(this).val()
        //     //                 );
        //     //
        //     //                 column
        //     //                     .search( val ? '^'+val+'$' : '', true, false )
        //     //                     .draw();
        //     //             } );
        //     //
        //     //         column.data().unique().sort().each( function ( d, j ) {
        //     //             select.append( '<option value="'+d+'">'+d+'</option>' )
        //     //         } );
        //     //         try {
        //     //             console.log("titulo"+column().title())
        //     //         }catch (e){
        //     //
        //     //         }
        //     //     } );
        //     // }
        //     // , "initComplete": function () {
        //     //     // Apply the search
        //     //     this.api().columns().every( function () {
        //     //         var that = this;
        //     //
        //     //         $( 'input', this.footer() ).on( 'keyup change clear', function () {
        //     //             if ( that.search() !== this.value ) {
        //     //                 that
        //     //                     .search( this.value )
        //     //                     .draw();
        //     //             }
        //     //         } );
        //     //     } );
        //     // },"searchPanes": {
        //     //     "viewTotal": true,
        //     //     "columns": [2,3,4,5]
        //     // }, "dom": 'Plfrtip'
        //
        // } );
        // //     .columns().every( function() {
        // //     var that = this;
        // //
        // //     $('input', this.footer()).on('keyup change', function() {
        // //         if (that.search() !== this.value) {
        // //             that
        // //                 .search(this.value)
        // //                 .draw();
        // //         }
        // //     });
        // // });
        // // dataFilter();
        //
        //
        //
        // document.getElementById("loading").innerHTML = "";
        //


    }
    if(e.data.cmd === 'getmodelolist'){

        modeloList(e.data.data)
    }
    if(e.data.cmd === 'Savemodelolist'){

        var obj = e.data.data
        var contador = obj.lenght;
        var count = 0;
        try {
            limpiarModelosDB()
        }catch (e){
            console.log("No hay nada en la DB")
        }

        $('#progreso').html("                        <div class='progress'>\n" +
            "                            <div class='progress-bar' role='progressbar' id='linebar' style='width: 0%;' aria-valuenow='0' aria-valuemin='0' aria-valuemax='100'>0%</div>\n"+
            "                       </div>;")
        for(var key in obj){
            agregarModeloDB(obj[key])
            count++;
            var total = count/contador;
            $('#linebar').css("width", total+'%');
            $('#linebar').html(total+'%');
        }

        $('#progreso').html("");

        alert("Datos Modelos sincronizados");

    }

    if(e.data.cmd === 'SaveActionlist'){

        var obj = e.data.data
        var contador = obj.lenght;
        var count = 0;
        try {
            limpiarActionDB(e.data.action)
        }catch (e){
            console.log("No hay DB registrada")
        }

        $('#progreso').html("                        <div class='progress'>\n" +
            "                            <div class='progress-bar' role='progressbar' id='linebar' style='width: 0%;' aria-valuenow='0' aria-valuemin='0' aria-valuemax='100'>0%</div>\n"+
            "                       </div>;")
        for(var key in obj){
            agregarProductoActionDB(obj[key],e.data.action)
            count++;
            var total = count/contador;
            $('#linebar').css("width", total+'%');
            $('#linebar').html(total+'%');
        }

        $('#progreso').html("");

        if(e.data.action==='destacado'){
            dest = true;
        }
        if(e.data.action==='nuevo'){
            nue = true
        }
        if(e.data.action==='oferta'){
            oft = true;
        }
        if(e.data.action==='vendpop'){
            pop = true;
        }

        if (oft ===true && nue === true && dest === true &&  pop === true) {
            oft = false;
            nue = false;
            dest = false;
            pop = false;
            alert("Datos Action sincronizados");
        }



    }

    if(e.data.cmd === 'getinventarioList'){
        inventarioList(e.data.data);
    }

    if(e.data.cmd === 'getactionProducto'){
        productoactionList(e.data.data,e.data.action);


        // $("#listadoModelo").empty()
        // var modelo = []
        // for(var key in e.data.data){
        //     var url = '<li><a class="selectbox-link0" href="#" style="font-family: Montserrat, sans-serif;font-size: 24PX;"><strong>'+e.data.data[key].modelo+'</strong><span>&nbsp;EXCLUSIVO</span></a></li>'
        //     $("#listadoModelo").prepend(url)
        // }
        // const selectBox = new SelectBox(".selectbox-title0",".selectbox-link0",".selectbox-result0",".accordion-select0","0");
        // const selectBox1 = new SelectBox(".selectbox-title1",".selectbox-link1",".selectbox-result1",".accordion-select1","1");
    }


    if(e.data.cmd === 'producto'){
        getProductoComplete(e.data.data,e.data.action);


    }

};
function reloadSlider(){

    if (oft ===true && nue === true && dest === true &&  pop === true){
        oft =false;
        nue = false;
        dest = false;
        pop = false;

        console.log("va a impri")
        $('.multiple-item-slider').slick({
            dots: true,
            infinite: true,
            speed: 300,
            arrows:true,
            slidesToShow: 5,
            slidesToScroll: 5,

            responsive: [
                {
                    breakpoint: 1280,
                    settings: {
                        slidesToShow: 4,
                        slidesToScroll: 4,
                        infinite: true,
                        arrows:true,
                        dots: true,
                    }
                },
                {
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3,
                        infinite: true,
                    }
                },
                {
                    breakpoint: 768,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2,
                        arrows:true,

                    }
                },
                {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        arrows:true,

                    }
                }

                // You can unslick at a given breakpoint now by adding:
                // settings: "unslick"
                // instead of a settings object
            ]
        });
        !function(factory){"function"==typeof define&&define.amd&&define.amd.jQuery?define(["jquery"],factory):factory("undefined"!=typeof module&&module.exports?require("jquery"):jQuery)}(function($){"use strict";function init(options){return!options||void 0!==options.allowPageScroll||void 0===options.swipe&&void 0===options.swipeStatus||(options.allowPageScroll=NONE),void 0!==options.click&&void 0===options.tap&&(options.tap=options.click),options||(options={}),options=$.extend({},$.fn.swipe.defaults,options),this.each(function(){var $this=$(this),plugin=$this.data(PLUGIN_NS);plugin||(plugin=new TouchSwipe(this,options),$this.data(PLUGIN_NS,plugin))})}function TouchSwipe(element,options){function touchStart(jqEvent){if(!(getTouchInProgress()||$(jqEvent.target).closest(options.excludedElements,$element).length>0)){var event=jqEvent.originalEvent?jqEvent.originalEvent:jqEvent;if(!event.pointerType||"mouse"!=event.pointerType||0!=options.fallbackToMouseEvents){var ret,touches=event.touches,evt=touches?touches[0]:event;return phase=PHASE_START,touches?fingerCount=touches.length:options.preventDefaultEvents!==!1&&jqEvent.preventDefault(),distance=0,direction=null,currentDirection=null,pinchDirection=null,duration=0,startTouchesDistance=0,endTouchesDistance=0,pinchZoom=1,pinchDistance=0,maximumsMap=createMaximumsData(),cancelMultiFingerRelease(),createFingerData(0,evt),!touches||fingerCount===options.fingers||options.fingers===ALL_FINGERS||hasPinches()?(startTime=getTimeStamp(),2==fingerCount&&(createFingerData(1,touches[1]),startTouchesDistance=endTouchesDistance=calculateTouchesDistance(fingerData[0].start,fingerData[1].start)),(options.swipeStatus||options.pinchStatus)&&(ret=triggerHandler(event,phase))):ret=!1,ret===!1?(phase=PHASE_CANCEL,triggerHandler(event,phase),ret):(options.hold&&(holdTimeout=setTimeout($.proxy(function(){$element.trigger("hold",[event.target]),options.hold&&(ret=options.hold.call($element,event,event.target))},this),options.longTapThreshold)),setTouchInProgress(!0),null)}}}function touchMove(jqEvent){var event=jqEvent.originalEvent?jqEvent.originalEvent:jqEvent;if(phase!==PHASE_END&&phase!==PHASE_CANCEL&&!inMultiFingerRelease()){var ret,touches=event.touches,evt=touches?touches[0]:event,currentFinger=updateFingerData(evt);if(endTime=getTimeStamp(),touches&&(fingerCount=touches.length),options.hold&&clearTimeout(holdTimeout),phase=PHASE_MOVE,2==fingerCount&&(0==startTouchesDistance?(createFingerData(1,touches[1]),startTouchesDistance=endTouchesDistance=calculateTouchesDistance(fingerData[0].start,fingerData[1].start)):(updateFingerData(touches[1]),endTouchesDistance=calculateTouchesDistance(fingerData[0].end,fingerData[1].end),pinchDirection=calculatePinchDirection(fingerData[0].end,fingerData[1].end)),pinchZoom=calculatePinchZoom(startTouchesDistance,endTouchesDistance),pinchDistance=Math.abs(startTouchesDistance-endTouchesDistance)),fingerCount===options.fingers||options.fingers===ALL_FINGERS||!touches||hasPinches()){if(direction=calculateDirection(currentFinger.start,currentFinger.end),currentDirection=calculateDirection(currentFinger.last,currentFinger.end),validateDefaultEvent(jqEvent,currentDirection),distance=calculateDistance(currentFinger.start,currentFinger.end),duration=calculateDuration(),setMaxDistance(direction,distance),ret=triggerHandler(event,phase),!options.triggerOnTouchEnd||options.triggerOnTouchLeave){var inBounds=!0;if(options.triggerOnTouchLeave){var bounds=getbounds(this);inBounds=isInBounds(currentFinger.end,bounds)}!options.triggerOnTouchEnd&&inBounds?phase=getNextPhase(PHASE_MOVE):options.triggerOnTouchLeave&&!inBounds&&(phase=getNextPhase(PHASE_END)),phase!=PHASE_CANCEL&&phase!=PHASE_END||triggerHandler(event,phase)}}else phase=PHASE_CANCEL,triggerHandler(event,phase);ret===!1&&(phase=PHASE_CANCEL,triggerHandler(event,phase))}}function touchEnd(jqEvent){var event=jqEvent.originalEvent?jqEvent.originalEvent:jqEvent,touches=event.touches;if(touches){if(touches.length&&!inMultiFingerRelease())return startMultiFingerRelease(event),!0;if(touches.length&&inMultiFingerRelease())return!0}return inMultiFingerRelease()&&(fingerCount=fingerCountAtRelease),endTime=getTimeStamp(),duration=calculateDuration(),didSwipeBackToCancel()||!validateSwipeDistance()?(phase=PHASE_CANCEL,triggerHandler(event,phase)):options.triggerOnTouchEnd||options.triggerOnTouchEnd===!1&&phase===PHASE_MOVE?(options.preventDefaultEvents!==!1&&jqEvent.cancelable!==!1&&jqEvent.preventDefault(),phase=PHASE_END,triggerHandler(event,phase)):!options.triggerOnTouchEnd&&hasTap()?(phase=PHASE_END,triggerHandlerForGesture(event,phase,TAP)):phase===PHASE_MOVE&&(phase=PHASE_CANCEL,triggerHandler(event,phase)),setTouchInProgress(!1),null}function touchCancel(){fingerCount=0,endTime=0,startTime=0,startTouchesDistance=0,endTouchesDistance=0,pinchZoom=1,cancelMultiFingerRelease(),setTouchInProgress(!1)}function touchLeave(jqEvent){var event=jqEvent.originalEvent?jqEvent.originalEvent:jqEvent;options.triggerOnTouchLeave&&(phase=getNextPhase(PHASE_END),triggerHandler(event,phase))}function removeListeners(){$element.unbind(START_EV,touchStart),$element.unbind(CANCEL_EV,touchCancel),$element.unbind(MOVE_EV,touchMove),$element.unbind(END_EV,touchEnd),LEAVE_EV&&$element.unbind(LEAVE_EV,touchLeave),setTouchInProgress(!1)}function getNextPhase(currentPhase){var nextPhase=currentPhase,validTime=validateSwipeTime(),validDistance=validateSwipeDistance(),didCancel=didSwipeBackToCancel();return!validTime||didCancel?nextPhase=PHASE_CANCEL:!validDistance||currentPhase!=PHASE_MOVE||options.triggerOnTouchEnd&&!options.triggerOnTouchLeave?!validDistance&&currentPhase==PHASE_END&&options.triggerOnTouchLeave&&(nextPhase=PHASE_CANCEL):nextPhase=PHASE_END,nextPhase}function triggerHandler(event,phase){var ret,touches=event.touches;return(didSwipe()||hasSwipes())&&(ret=triggerHandlerForGesture(event,phase,SWIPE)),(didPinch()||hasPinches())&&ret!==!1&&(ret=triggerHandlerForGesture(event,phase,PINCH)),didDoubleTap()&&ret!==!1?ret=triggerHandlerForGesture(event,phase,DOUBLE_TAP):didLongTap()&&ret!==!1?ret=triggerHandlerForGesture(event,phase,LONG_TAP):didTap()&&ret!==!1&&(ret=triggerHandlerForGesture(event,phase,TAP)),phase===PHASE_CANCEL&&touchCancel(event),phase===PHASE_END&&(touches?touches.length||touchCancel(event):touchCancel(event)),ret}function triggerHandlerForGesture(event,phase,gesture){var ret;if(gesture==SWIPE){if($element.trigger("swipeStatus",[phase,direction||null,distance||0,duration||0,fingerCount,fingerData,currentDirection]),options.swipeStatus&&(ret=options.swipeStatus.call($element,event,phase,direction||null,distance||0,duration||0,fingerCount,fingerData,currentDirection),ret===!1))return!1;if(phase==PHASE_END&&validateSwipe()){if(clearTimeout(singleTapTimeout),clearTimeout(holdTimeout),$element.trigger("swipe",[direction,distance,duration,fingerCount,fingerData,currentDirection]),options.swipe&&(ret=options.swipe.call($element,event,direction,distance,duration,fingerCount,fingerData,currentDirection),ret===!1))return!1;switch(direction){case LEFT:$element.trigger("swipeLeft",[direction,distance,duration,fingerCount,fingerData,currentDirection]),options.swipeLeft&&(ret=options.swipeLeft.call($element,event,direction,distance,duration,fingerCount,fingerData,currentDirection));break;case RIGHT:$element.trigger("swipeRight",[direction,distance,duration,fingerCount,fingerData,currentDirection]),options.swipeRight&&(ret=options.swipeRight.call($element,event,direction,distance,duration,fingerCount,fingerData,currentDirection));break;case UP:$element.trigger("swipeUp",[direction,distance,duration,fingerCount,fingerData,currentDirection]),options.swipeUp&&(ret=options.swipeUp.call($element,event,direction,distance,duration,fingerCount,fingerData,currentDirection));break;case DOWN:$element.trigger("swipeDown",[direction,distance,duration,fingerCount,fingerData,currentDirection]),options.swipeDown&&(ret=options.swipeDown.call($element,event,direction,distance,duration,fingerCount,fingerData,currentDirection))}}}if(gesture==PINCH){if($element.trigger("pinchStatus",[phase,pinchDirection||null,pinchDistance||0,duration||0,fingerCount,pinchZoom,fingerData]),options.pinchStatus&&(ret=options.pinchStatus.call($element,event,phase,pinchDirection||null,pinchDistance||0,duration||0,fingerCount,pinchZoom,fingerData),ret===!1))return!1;if(phase==PHASE_END&&validatePinch())switch(pinchDirection){case IN:$element.trigger("pinchIn",[pinchDirection||null,pinchDistance||0,duration||0,fingerCount,pinchZoom,fingerData]),options.pinchIn&&(ret=options.pinchIn.call($element,event,pinchDirection||null,pinchDistance||0,duration||0,fingerCount,pinchZoom,fingerData));break;case OUT:$element.trigger("pinchOut",[pinchDirection||null,pinchDistance||0,duration||0,fingerCount,pinchZoom,fingerData]),options.pinchOut&&(ret=options.pinchOut.call($element,event,pinchDirection||null,pinchDistance||0,duration||0,fingerCount,pinchZoom,fingerData))}}return gesture==TAP?phase!==PHASE_CANCEL&&phase!==PHASE_END||(clearTimeout(singleTapTimeout),clearTimeout(holdTimeout),hasDoubleTap()&&!inDoubleTap()?(doubleTapStartTime=getTimeStamp(),singleTapTimeout=setTimeout($.proxy(function(){doubleTapStartTime=null,$element.trigger("tap",[event.target]),options.tap&&(ret=options.tap.call($element,event,event.target))},this),options.doubleTapThreshold)):(doubleTapStartTime=null,$element.trigger("tap",[event.target]),options.tap&&(ret=options.tap.call($element,event,event.target)))):gesture==DOUBLE_TAP?phase!==PHASE_CANCEL&&phase!==PHASE_END||(clearTimeout(singleTapTimeout),clearTimeout(holdTimeout),doubleTapStartTime=null,$element.trigger("doubletap",[event.target]),options.doubleTap&&(ret=options.doubleTap.call($element,event,event.target))):gesture==LONG_TAP&&(phase!==PHASE_CANCEL&&phase!==PHASE_END||(clearTimeout(singleTapTimeout),doubleTapStartTime=null,$element.trigger("longtap",[event.target]),options.longTap&&(ret=options.longTap.call($element,event,event.target)))),ret}function validateSwipeDistance(){var valid=!0;return null!==options.threshold&&(valid=distance>=options.threshold),valid}function didSwipeBackToCancel(){var cancelled=!1;return null!==options.cancelThreshold&&null!==direction&&(cancelled=getMaxDistance(direction)-distance>=options.cancelThreshold),cancelled}function validatePinchDistance(){return null===options.pinchThreshold||pinchDistance>=options.pinchThreshold}function validateSwipeTime(){var result;return result=!options.maxTimeThreshold||!(duration>=options.maxTimeThreshold)}function validateDefaultEvent(jqEvent,direction){if(options.preventDefaultEvents!==!1)if(options.allowPageScroll===NONE)jqEvent.preventDefault();else{var auto=options.allowPageScroll===AUTO;switch(direction){case LEFT:(options.swipeLeft&&auto||!auto&&options.allowPageScroll!=HORIZONTAL)&&jqEvent.preventDefault();break;case RIGHT:(options.swipeRight&&auto||!auto&&options.allowPageScroll!=HORIZONTAL)&&jqEvent.preventDefault();break;case UP:(options.swipeUp&&auto||!auto&&options.allowPageScroll!=VERTICAL)&&jqEvent.preventDefault();break;case DOWN:(options.swipeDown&&auto||!auto&&options.allowPageScroll!=VERTICAL)&&jqEvent.preventDefault();break;case NONE:}}}function validatePinch(){var hasCorrectFingerCount=validateFingers(),hasEndPoint=validateEndPoint(),hasCorrectDistance=validatePinchDistance();return hasCorrectFingerCount&&hasEndPoint&&hasCorrectDistance}function hasPinches(){return!!(options.pinchStatus||options.pinchIn||options.pinchOut)}function didPinch(){return!(!validatePinch()||!hasPinches())}function validateSwipe(){var hasValidTime=validateSwipeTime(),hasValidDistance=validateSwipeDistance(),hasCorrectFingerCount=validateFingers(),hasEndPoint=validateEndPoint(),didCancel=didSwipeBackToCancel(),valid=!didCancel&&hasEndPoint&&hasCorrectFingerCount&&hasValidDistance&&hasValidTime;return valid}function hasSwipes(){return!!(options.swipe||options.swipeStatus||options.swipeLeft||options.swipeRight||options.swipeUp||options.swipeDown)}function didSwipe(){return!(!validateSwipe()||!hasSwipes())}function validateFingers(){return fingerCount===options.fingers||options.fingers===ALL_FINGERS||!SUPPORTS_TOUCH}function validateEndPoint(){return 0!==fingerData[0].end.x}function hasTap(){return!!options.tap}function hasDoubleTap(){return!!options.doubleTap}function hasLongTap(){return!!options.longTap}function validateDoubleTap(){if(null==doubleTapStartTime)return!1;var now=getTimeStamp();return hasDoubleTap()&&now-doubleTapStartTime<=options.doubleTapThreshold}function inDoubleTap(){return validateDoubleTap()}function validateTap(){return(1===fingerCount||!SUPPORTS_TOUCH)&&(isNaN(distance)||distance<options.threshold)}function validateLongTap(){return duration>options.longTapThreshold&&distance<DOUBLE_TAP_THRESHOLD}function didTap(){return!(!validateTap()||!hasTap())}function didDoubleTap(){return!(!validateDoubleTap()||!hasDoubleTap())}function didLongTap(){return!(!validateLongTap()||!hasLongTap())}function startMultiFingerRelease(event){previousTouchEndTime=getTimeStamp(),fingerCountAtRelease=event.touches.length+1}function cancelMultiFingerRelease(){previousTouchEndTime=0,fingerCountAtRelease=0}function inMultiFingerRelease(){var withinThreshold=!1;if(previousTouchEndTime){var diff=getTimeStamp()-previousTouchEndTime;diff<=options.fingerReleaseThreshold&&(withinThreshold=!0)}return withinThreshold}function getTouchInProgress(){return!($element.data(PLUGIN_NS+"_intouch")!==!0)}function setTouchInProgress(val){$element&&(val===!0?($element.bind(MOVE_EV,touchMove),$element.bind(END_EV,touchEnd),LEAVE_EV&&$element.bind(LEAVE_EV,touchLeave)):($element.unbind(MOVE_EV,touchMove,!1),$element.unbind(END_EV,touchEnd,!1),LEAVE_EV&&$element.unbind(LEAVE_EV,touchLeave,!1)),$element.data(PLUGIN_NS+"_intouch",val===!0))}function createFingerData(id,evt){var f={start:{x:0,y:0},last:{x:0,y:0},end:{x:0,y:0}};return f.start.x=f.last.x=f.end.x=evt.pageX||evt.clientX,f.start.y=f.last.y=f.end.y=evt.pageY||evt.clientY,fingerData[id]=f,f}function updateFingerData(evt){var id=void 0!==evt.identifier?evt.identifier:0,f=getFingerData(id);return null===f&&(f=createFingerData(id,evt)),f.last.x=f.end.x,f.last.y=f.end.y,f.end.x=evt.pageX||evt.clientX,f.end.y=evt.pageY||evt.clientY,f}function getFingerData(id){return fingerData[id]||null}function setMaxDistance(direction,distance){direction!=NONE&&(distance=Math.max(distance,getMaxDistance(direction)),maximumsMap[direction].distance=distance)}function getMaxDistance(direction){if(maximumsMap[direction])return maximumsMap[direction].distance}function createMaximumsData(){var maxData={};return maxData[LEFT]=createMaximumVO(LEFT),maxData[RIGHT]=createMaximumVO(RIGHT),maxData[UP]=createMaximumVO(UP),maxData[DOWN]=createMaximumVO(DOWN),maxData}function createMaximumVO(dir){return{direction:dir,distance:0}}function calculateDuration(){return endTime-startTime}function calculateTouchesDistance(startPoint,endPoint){var diffX=Math.abs(startPoint.x-endPoint.x),diffY=Math.abs(startPoint.y-endPoint.y);return Math.round(Math.sqrt(diffX*diffX+diffY*diffY))}function calculatePinchZoom(startDistance,endDistance){var percent=endDistance/startDistance*1;return percent.toFixed(2)}function calculatePinchDirection(){return pinchZoom<1?OUT:IN}function calculateDistance(startPoint,endPoint){return Math.round(Math.sqrt(Math.pow(endPoint.x-startPoint.x,2)+Math.pow(endPoint.y-startPoint.y,2)))}function calculateAngle(startPoint,endPoint){var x=startPoint.x-endPoint.x,y=endPoint.y-startPoint.y,r=Math.atan2(y,x),angle=Math.round(180*r/Math.PI);return angle<0&&(angle=360-Math.abs(angle)),angle}function calculateDirection(startPoint,endPoint){if(comparePoints(startPoint,endPoint))return NONE;var angle=calculateAngle(startPoint,endPoint);return angle<=45&&angle>=0?LEFT:angle<=360&&angle>=315?LEFT:angle>=135&&angle<=225?RIGHT:angle>45&&angle<135?DOWN:UP}function getTimeStamp(){var now=new Date;return now.getTime()}function getbounds(el){el=$(el);var offset=el.offset(),bounds={left:offset.left,right:offset.left+el.outerWidth(),top:offset.top,bottom:offset.top+el.outerHeight()};return bounds}function isInBounds(point,bounds){return point.x>bounds.left&&point.x<bounds.right&&point.y>bounds.top&&point.y<bounds.bottom}function comparePoints(pointA,pointB){return pointA.x==pointB.x&&pointA.y==pointB.y}var options=$.extend({},options),useTouchEvents=SUPPORTS_TOUCH||SUPPORTS_POINTER||!options.fallbackToMouseEvents,START_EV=useTouchEvents?SUPPORTS_POINTER?SUPPORTS_POINTER_IE10?"MSPointerDown":"pointerdown":"touchstart":"mousedown",MOVE_EV=useTouchEvents?SUPPORTS_POINTER?SUPPORTS_POINTER_IE10?"MSPointerMove":"pointermove":"touchmove":"mousemove",END_EV=useTouchEvents?SUPPORTS_POINTER?SUPPORTS_POINTER_IE10?"MSPointerUp":"pointerup":"touchend":"mouseup",LEAVE_EV=useTouchEvents?SUPPORTS_POINTER?"mouseleave":null:"mouseleave",CANCEL_EV=SUPPORTS_POINTER?SUPPORTS_POINTER_IE10?"MSPointerCancel":"pointercancel":"touchcancel",distance=0,direction=null,currentDirection=null,duration=0,startTouchesDistance=0,endTouchesDistance=0,pinchZoom=1,pinchDistance=0,pinchDirection=0,maximumsMap=null,$element=$(element),phase="start",fingerCount=0,fingerData={},startTime=0,endTime=0,previousTouchEndTime=0,fingerCountAtRelease=0,doubleTapStartTime=0,singleTapTimeout=null,holdTimeout=null;try{$element.bind(START_EV,touchStart),$element.bind(CANCEL_EV,touchCancel)}catch(e){$.error("events not supported "+START_EV+","+CANCEL_EV+" on jQuery.swipe")}this.enable=function(){return this.disable(),$element.bind(START_EV,touchStart),$element.bind(CANCEL_EV,touchCancel),$element},this.disable=function(){return removeListeners(),$element},this.destroy=function(){removeListeners(),$element.data(PLUGIN_NS,null),$element=null},this.option=function(property,value){if("object"==typeof property)options=$.extend(options,property);else if(void 0!==options[property]){if(void 0===value)return options[property];options[property]=value}else{if(!property)return options;$.error("Option "+property+" does not exist on jQuery.swipe.options")}return null}}var VERSION="1.6.18",LEFT="left",RIGHT="right",UP="up",DOWN="down",IN="in",OUT="out",NONE="none",AUTO="auto",SWIPE="swipe",PINCH="pinch",TAP="tap",DOUBLE_TAP="doubletap",LONG_TAP="longtap",HORIZONTAL="horizontal",VERTICAL="vertical",ALL_FINGERS="all",DOUBLE_TAP_THRESHOLD=10,PHASE_START="start",PHASE_MOVE="move",PHASE_END="end",PHASE_CANCEL="cancel",SUPPORTS_TOUCH="ontouchstart"in window,SUPPORTS_POINTER_IE10=window.navigator.msPointerEnabled&&!window.navigator.pointerEnabled&&!SUPPORTS_TOUCH,SUPPORTS_POINTER=(window.navigator.pointerEnabled||window.navigator.msPointerEnabled)&&!SUPPORTS_TOUCH,PLUGIN_NS="TouchSwipe",defaults={fingers:1,threshold:75,cancelThreshold:null,pinchThreshold:20,maxTimeThreshold:null,fingerReleaseThreshold:250,longTapThreshold:500,doubleTapThreshold:200,swipe:null,swipeLeft:null,swipeRight:null,swipeUp:null,swipeDown:null,swipeStatus:null,pinchIn:null,pinchOut:null,pinchStatus:null,click:null,tap:null,doubleTap:null,longTap:null,hold:null,triggerOnTouchEnd:!0,triggerOnTouchLeave:!1,allowPageScroll:"auto",fallbackToMouseEvents:!0,excludedElements:".noSwipe",preventDefaultEvents:!0};$.fn.swipe=function(method){var $this=$(this),plugin=$this.data(PLUGIN_NS);if(plugin&&"string"==typeof method){if(plugin[method])return plugin[method].apply(plugin,Array.prototype.slice.call(arguments,1));$.error("Method "+method+" does not exist on jQuery.swipe")}else if(plugin&&"object"==typeof method)plugin.option.apply(plugin,arguments);else if(!(plugin||"object"!=typeof method&&method))return init.apply(this,arguments);return $this},$.fn.swipe.version=VERSION,$.fn.swipe.defaults=defaults,$.fn.swipe.phases={PHASE_START:PHASE_START,PHASE_MOVE:PHASE_MOVE,PHASE_END:PHASE_END,PHASE_CANCEL:PHASE_CANCEL},$.fn.swipe.directions={LEFT:LEFT,RIGHT:RIGHT,UP:UP,DOWN:DOWN,IN:IN,OUT:OUT},$.fn.swipe.pageScroll={NONE:NONE,HORIZONTAL:HORIZONTAL,VERTICAL:VERTICAL,AUTO:AUTO},$.fn.swipe.fingers={ONE:1,TWO:2,THREE:3,FOUR:4,FIVE:5,ALL:ALL_FINGERS}});


        !function(t){t("[data-modal-id]").each(function(){var i=t(this),a=t(this).attr("data-modal-id");""!==a&&t("#"+a).each(function(){var a=t(this),o=t(this)[0].hasAttribute("data-modal-backdrop"),s=t(this).attr("data-modal-backdrop"),n=t(this)[0].hasAttribute("data-show-on"),e=t(this).attr("data-show-on"),r=t(this)[0].hasAttribute("data-modal-delay"),d=t(this).attr("data-modal-delay"),c=t.isNumeric(d),l=t(this)[0].hasAttribute("data-modal-duration"),h=t(this).attr("data-modal-duration"),u=t.isNumeric(h);!0===l&&!0===u&&t(a).on("shown.bs.modal",function(){setTimeout(function(){t(a).modal("hide")},h)}),!0===n?"load"===e?(t(i).css({display:"none"}),!0===r&&!0===c?t(window).on("load",function(){setTimeout(function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})},d)}):t(window).on("load",function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})})):"leave"===e?(t(i).css({display:"none"}),!0===r&&!0===c?t(document).one("mouseleave",function(){setTimeout(function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})},d)}):t(document).one("mouseleave",function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})})):"hover"===e?!0===r&&!0===c?t(i).hover(function(){setTimeout(function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})},d)}):t(i).hover(function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})}):!0===r&&!0===c?t(i).click(function(){setTimeout(function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})},d)}):t(i).click(function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})}):!0===r&&!0===c?t(i).click(function(){setTimeout(function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})},d)}):t(i).click(function(){!0===o?"static"===s?t(a).modal({backdrop:"static"}):"false"===s?t(a).modal({backdrop:!1}):t(a).modal({backdrop:!0}):t(a).modal({backdrop:!0})})})}),t(".modal.bs4_modal").on("show.bs.modal",function(){t(this).find(".bs4-carousel").each(function(){var i=t(this).attr("data-duration");t.fn.carousel.Constructor.TRANSITION_DURATION=i,t(this).find(".carousel-item").each(function(){t(this).css({"-webkit-transition-duration":i+"ms","-moz-transition-duration":i+"ms","transition-duration":i+"ms"})})})});var i=t(".carousel").hasClass("swipe-y"),a=t(".carousel").hasClass("swipe-x");!0===i&&t(".swipe-y .carousel-inner").swipe({swipeUp:function(i,a,o,s,n){t(this).parent().carousel("next")},swipeDown:function(){t(this).parent().carousel("prev")},threshold:0}),!0===a&&t(".swipe-x .carousel-inner").swipe({swipeLeft:function(i,a,o,s,n){t(this).parent().carousel("next")},swipeRight:function(i,a,o,s,n){t(this).parent().carousel("prev")},threshold:0});var o=t(".carousel").hasClass("thumb-scroll-x"),s=t(".carousel").hasClass("thumb-scroll-y");if(!0===o&&t(".thumb-scroll-x").each(function(){var i=0;t(this).on("slide.bs.carousel",function(){var a=-1*t(this).find(".carousel-indicators li:first-child").position().left+t(this).find(".carousel-indicators li:last-child").position().left+t(this).find(".carousel-indicators li:last-child").width(),o=t(this).find(".carousel-indicators li.active").position().left+t(this).find(".carousel-indicators li.active").width()/1.2+i-t(this).find(".carousel-indicators").width()/1.2;o<0&&(o=0),o>a-t(this).find(".carousel-indicators").width()&&(o=a-t(this).find(".carousel-indicators").width()),t(this).find(".carousel-indicators").animate({scrollLeft:o},800),i=o}),t(this).on("slid.bs.carousel",function(){var a=-1*t(this).find(".carousel-indicators li:first-child").position().left+t(this).find(".carousel-indicators li:last-child").position().left+t(this).find(".carousel-indicators li:last-child").width(),o=t(this).find(".carousel-indicators li.active").position().left+t(this).find(".carousel-indicators li.active").width()/1.2+i-t(this).find(".carousel-indicators").width()/1.2;o<0&&(o=0),o>a-t(this).find(".carousel-indicators").width()&&(o=a-t(this).find(".carousel-indicators").width()),t(this).find(".carousel-indicators").animate({scrollLeft:o},800),i=o})}),!0===s){var n=0;t(".thumb-scroll-y").each(function(){t(this).on("slide.bs.carousel",function(){var i=-1*t(this).find(".carousel-indicators li:first").position().top+t(this).find(".carousel-indicators li:last").position().top+t(this).find(".carousel-indicators li:last").height(),a=t(this).find(".carousel-indicators li.active").position().top+t(this).find(".carousel-indicators li.active").height()/1.2+n-t(this).find(".carousel-indicators").height()/1.2;a<0&&(a=0),a>i-t(this).find(".carousel-indicators").height()&&(a=i-t(this).find(".carousel-indicators").height()),t(this).find(".carousel-indicators").animate({scrollTop:a},800),n=a}),t(this).on("slid.bs.carousel",function(){var i=-1*t(this).find(".carousel-indicators li:first").position().top+t(this).find(".carousel-indicators li:last").position().top+t(this).find(".carousel-indicators li:last").height(),a=t(this).find(".carousel-indicators li.active").position().top+t(this).find(".carousel-indicators li.active").height()/1.2+n-t(this).find(".carousel-indicators").height()/1.2;a<0&&(a=0),a>i-t(this).find(".carousel-indicators").height()&&(a=i-t(this).find(".carousel-indicators").height()),t(this).find(".carousel-indicators").animate({scrollTop:a},800),n=a})})}t(".bs4-carousel").each(function(){var i,a=t(this),o=a[0].hasAttribute("data-column");if(!0===o){function s(){var i=a.attr("id"),s=a.find(".carousel-item"),n=t(s).length,e=a.attr("data-column"),r=a.attr("data-m1200"),d=a[0].hasAttribute("data-m1200"),c=a.attr("data-m992"),l=a[0].hasAttribute("data-m992"),h=a.attr("data-m768"),u=a[0].hasAttribute("data-m768"),f=a.attr("data-m576"),m=a[0].hasAttribute("data-m576");function p(o,r,d,c){if(t("#"+i).css({display:"block"}),!0===o)var l=r;else l=e;if(""!==l&&l>0&&l<=n){if(window.matchMedia(d).matches){t(s).each(function(){var i=t(this);i.find(".cloneditems").remove();for(var a=1;a<l;a++)(i=i.next()).length||(i=t(this).siblings(":first")),i.children(":first-child").children(":first-child").clone().addClass("cloneditem-"+a+" cloneditems").appendTo(t(this).children(":first-child"))});var h=100/l+"%";t(s).on("slideIsChanging",function(){a.find(".active.carousel-item-left, .carousel-item-prev").css({"-webkit-transform":"translateX(-"+h+")",transform:"translateX(-"+h+")","-webkit-transform":"-webkit-translate3d(-"+h+",0,0)",transform:"translate3d(-"+h+",0,0)"}),a.find(".carousel-item-next, .active.carousel-item-right").css({"-webkit-transform":"translateX("+h+")",transform:"translateX("+h+")","-webkit-transform":"-webkit-translate3d("+h+",0,0)",transform:"translate3d("+h+",0,0)"}),a.find(".carousel-item-next.carousel-item-left, .carousel-item-prev.carousel-item-right").css({"-webkit-transform":"translateX(0)",transform:"translateX(0)","-webkit-transform":"-webkit-translate3d(0,0,0)",transform:"translate3d(0,0,0)"})})}}else{var u="In Slider Id : #"+i;u+="\n",u+="You are assigning the value ("+l+") to the (data-"+c+") attribute. Which is greater than numbers of carousel-item those you are creating ("+n+")",u+="\n\n",u+="Please make sure the value of (data-"+c+") should be <= to numbers of carousel-item ("+n+").",u+="\n\n",u+="Note : The values should not be 0 or empty And also (Positive Integers only)",alert(u),t("#"+i).css({display:"none"})}}p(o,e,"(min-width: 1201px)","column"),p(d,r,"(min-width: 993px) and (max-width: 1200px)","m1200"),p(l,c,"(min-width: 769px) and (max-width: 992px)","m992"),p(u,h,"(min-width: 577px) and (max-width: 768px)","m768"),p(m,f,"(max-width: 576px)","m576")}i=jQuery.fn.addClass,jQuery.fn.addClass=function(){var t=i.apply(this,arguments);return jQuery(this).trigger("slideIsChanging"),t},s(),t(window).resize(function(){clearTimeout(a.id),a.id=setTimeout(s,100)})}}),t(".pauseVideo").on("slide.bs.carousel",function(){t("video").each(function(){this.pause()})}),t(".pauseVideoM").on("hide.bs.modal",function(){t("video").each(function(){this.pause()})}),t(".onlinePauseVideo").on("slide.bs.carousel",function(i){t(i.target).find("iframe").each(function(i,a){t(a).attr("src",t(a).attr("src"))})}),t(".onlinePauseVideoM").on("hide.bs.modal",function(i){t(i.target).find("iframe").each(function(i,a){t(a).attr("src",t(a).attr("src"))})})}(jQuery);

    }else {


    }



    // $('.multiple-item-slider')[0].slick.refresh()
    // $('.multiple-item-slider')[1].slick.refresh()
    // $('.multiple-item-slider')[2].slick.refresh()
    // $('.multiple-item-slider')[3].slick.refresh()
    // $('.multiple-item-slider').slick({
    //     dots: true,
    //     infinite: true,
    //     speed: 300,
    //     arrows:true,
    //     slidesToShow: 5,
    //     slidesToScroll: 5,
    //
    //     responsive: [
    //         {
    //             breakpoint: 1280,
    //             settings: {
    //                 slidesToShow: 4,
    //                 slidesToScroll: 4,
    //                 infinite: true,
    //                 arrows:true,
    //                 dots: true,
    //             }
    //         },
    //         {
    //             breakpoint: 1024,
    //             settings: {
    //                 slidesToShow: 3,
    //                 slidesToScroll: 3,
    //                 infinite: true,
    //             }
    //         },
    //         {
    //             breakpoint: 768,
    //             settings: {
    //                 slidesToShow: 2,
    //                 slidesToScroll: 2,
    //                 arrows:true,
    //
    //             }
    //         },
    //         {
    //             breakpoint: 480,
    //             settings: {
    //                 slidesToShow: 1,
    //                 slidesToScroll: 1,
    //                 arrows:true,
    //
    //             }
    //         }
    //
    //         // You can unslick at a given breakpoint now by adding:
    //         // settings: "unslick"
    //         // instead of a settings object
    //     ]
    // });
}


function callWait(){
    reloadSlider()
}

function getProducto(codigo){
    console.log("\n\nHola")
    var obj = buscarProductoDB(codigo,"impPrin")

    // worker.postMessage({'cmd': 'getProducto', 'id': codigo});
}

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

// function startLoading(){
//     $("#modalLoading").modal({
//         backdrop: 'static',
//         keyboard: false
//     })
//     $('#modalLoading').modal('show');
//     $("#modalLoading").css("display", "block");
// }
// function stopLoading(){
//     setTimeout(stopNowLoading,1000);
//
// }
// function actionRelation(actionJson){
//     switch (actionJson.typeClass) {
//         case "Producto":
//             startLoading();
//             worker.postMessage({'cmd': 'productoRelation', 'ActionJson': actionJson});
//             break;
//         case "Venta":
//             startLoading();
//             worker.postMessage({'cmd': 'ventaRelation', 'ActionJson': actionJson});
//             break;
//         default:
//             break;
//
//
//     }
// }
// function verifyUser(){
//     var employee = {
//         user: document.getElementById("user").value,
//         password: document.getElementById("password").value
//     }
//     startLoading()
//     worker.postMessage({'cmd': 'login', 'user': JSON.stringify(employee)});
// }
// function stopNowLoading(){
//     $('#modalLoading').modal('hide');
//     $("#modalLoading").css("display", "none");
// }
//
// function setCookie(cname,cvalue,exdays) {
//     var d = new Date();
//     d.setTime(d.getTime() + (exdays*24*60*60*1000));
//     var expires = "expires=" + d.toGMTString();
//     document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
// }
//
// function getCookie(cname) {
//     var name = cname + "=";
//     var decodedCookie = decodeURIComponent(document.cookie);
//     var ca = decodedCookie.split(';');
//     for(var i = 0; i < ca.length; i++) {
//         var c = ca[i];
//         while (c.charAt(0) == ' ') {
//             c = c.substring(1);
//         }
//         if (c.indexOf(name) == 0) {
//             return c.substring(name.length, c.length);
//         }
//     }
//     return "";
// }

