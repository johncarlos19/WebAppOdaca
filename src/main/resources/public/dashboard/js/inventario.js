


function openFiles(evt){
    var files = evt.target.files;

    for (var i = 0, len = files.length; i < len; i++) {
        var file = files[i];

        var reader = new FileReader();

        reader.onload = (function(f) {
            return function(e) {
                // Here you can use `e.target.result` or `this.result`
                // and `f.name`.
            };
        })(file);

        reader.readAsText(file);
    }
}
$('#ubication').submit(function() {
    saveUbiCoockie()
    return true; // return false to cancel form action
});
function saveUbiCoockie(){
    setCookie("columna",document.getElementById("columnaSelect").value,1);
    setCookie("fila",document.getElementById("fila").value,1);
    setCookie("nave",document.getElementById("naveSelect").value,1);
    setCookie("rack",document.getElementById("rack").value,1);

}

function resizePhoto(image,x,y){
    var reader = new FileReader();
    var file1 = image;
    // document.getElementById("imagenSave").files[0]


        var mimetype = file1.type
        var nombreImg = file1.name


        reader.readAsDataURL(file1);
        var fi
        reader.onload = function () {

            var base6412;
            console.log("Esto es lo prim" + reader.result)
            resizeBase64Img(reader.result, x, x).then(resized=>{

                base6412 = resized;
                // console.log("sale esto"+base6412)
                let temp = {
                    base64: base6412,
                    mimetype: mimetype,
                    nombreImg: nombreImg
                }
                document.getElementById("imgActual").src = temp.base64;
                document.getElementById("photoResize").value = temp.base64;
                document.getElementById("mimetype").value = temp.mimetype;
                document.getElementById("namePhoto").value = temp.nombreImg;
                document.getElementById('imgActual').setAttribute("onclick",'openNewTab("'+temp.base64+'")');
                document.getElementById('abrirLista').setAttribute("onclick",'openNewTab("'+temp.base64+'")');
                var file = dataURLtoFile(temp.base64,temp.nombreImg)
                document.getElementById("sizeLista").value = file.size/1024
                // document.getElementById("previsual").src = base6412;
                // document.getElementById("showIMG").innerHTML = '<img class="img" id="imgActual"  src="'+base6412+'"   />';

                // console.log(temp)


            });
            resizeBase64Img(reader.result, y, y).then(resized=>{

                base6412 = resized;
                // console.log("sale esto"+base6412)
                let temp = {
                    base64: base6412,
                    mimetype: mimetype,
                    nombreImg: nombreImg
                }
                document.getElementById("photoOri").value = temp.base64;

                document.getElementById('abrirOri').setAttribute("onclick",'openNewTab("'+temp.base64+'")');
                file = dataURLtoFile(temp.base64,temp.nombreImg)
                document.getElementById("sizeOri").value = file.size/1024
                // document.getElementById("previsual").src = base6412;
                // document.getElementById("showIMG").innerHTML = '<img class="img" id="imgActual"  src="'+base6412+'"   />';

                // console.log(temp)


            });












        };

        reader.onerror = function (error) {
            console.log('Error: ', error);
        };

        return fi;

}

function openNewTab(data) {
    var image = new Image();
    image.src =  data;

    var w = window.open("");
    w.document.write(image.outerHTML);
}

function dataURLtoFile(dataurl, filename) {

    var arr = dataurl.split(','),
        mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]),
        n = bstr.length,
        u8arr = new Uint8Array(n);

    while(n--){
        u8arr[n] = bstr.charCodeAt(n);
    }

    return new File([u8arr], filename, {type:mime});
}



function resizeBase64Img(base64, newWidth, newHeight) {
    return new Promise((resolve, reject)=>{


        var canvas = document.createElement("canvas");
        canvas.style.width = newWidth.toString()+"px";
        canvas.style.height = newHeight.toString()+"px";
        let context = canvas.getContext("2d");
        let img = document.createElement("img");
        img.src = base64;
        img.onload = function () {
            var iw=img.width;
            var ih=img.height;
            var scale=Math.min((newWidth/iw),(newHeight/ih));
            var iwScaled=iw*scale;
            var ihScaled=ih*scale;
            canvas.width=iwScaled;
            canvas.height=ihScaled;

            // context.scale(newWidth/img.width,  newHeight/img.height);
            context.drawImage(img, 0, 0,iwScaled,ihScaled);
            resolve(canvas.toDataURL());
        }
    });
}

$(".nuevaImagen").change(function(){

    var imagen = this.files[0];
    var tamx = document.getElementById("tamLista").value;
    var tamy = document.getElementById("tamOri").value;

    var temp = resizePhoto(imagen,tamx,tamy);






        // var datosImagen = new FileReader;
        // datosImagen.readAsDataURL(imagen);
        //
        // $(datosImagen).on("load", function(event){
        //
        //     var rutaImagen = event.target.result;
        //
        //     $(".previsualizar").attr("src", rutaImagen);
        //
        // })


})
$(".changeTamano").change(function(){

    var imagen = document.getElementById("imagenSave").files[0];
    var tamx = document.getElementById("tamLista").value;
    var tamy = document.getElementById("tamOri").value;

    var photorender = resizePhoto(imagen,tamx,tamy);


        // var datosImagen = new FileReader;
        // datosImagen.readAsDataURL(imagen);
        //
        // $(datosImagen).on("load", function(event){
        //
        //     var rutaImagen = event.target.result;
        //
        //     $(".previsualizar").attr("src", rutaImagen);
        //
        // })


})


function editarFotoInfo(){
    var reader = new FileReader();
    var file1 = document.getElementById("imagenSave").files[0]

    if (document.getElementById("imagenSave").files.length == 0){
        let temp = {
            base64: null,
            mimetype: null,
            nombreImg: null
        }
        console.log(temp)
        document.getElementById("previsual").src = "../dashboardPlantilla/img/productos/default/anonymous.png";
        document.getElementById("imgActual").src = "../dashboardPlantilla/img/productos/default/anonymous.png";
        var actionJson ={
            id: parseInt(document.getElementById("idProducto").value),
            typeClass: "Producto",
            action: "editarFotoProducto",
            detail: JSON.stringify(temp),
            anotherID: parseInt(document.getElementById("idImagenSave").value)
        }
        actionRelation(actionJson);

    }else{
        var mimetype = file1.type
        var nombreImg = file1.name


        reader.readAsDataURL(file1);
        reader.onload = function () {

            var base6412;
            console.log("Esto es lo prim" + reader.result)
            resizeBase64Img(reader.result, 150, 150).then(resized=>{

                base6412 = resized;
                console.log("sale esto"+base6412)
                let temp = {
                    base64: base6412,
                    mimetype: mimetype,
                    nombreImg: nombreImg
                }
                document.getElementById("previsual").src = base6412;
                document.getElementById("imgActual").src = base6412;
                console.log(temp)
                var actionJson ={
                    id: parseInt(document.getElementById("idProducto").value),
                    typeClass: "Producto",
                    action: "editarFotoProducto",
                    detail: JSON.stringify(temp),
                    anotherID: parseInt(document.getElementById("idImagenSave").value)
                }
                actionRelation(actionJson);

            });



        };
        reader.onerror = function (error) {
            console.log('Error: ', error);
        };

    }


}