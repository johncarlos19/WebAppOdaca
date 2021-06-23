$(".table").on("click", ".btnEliminar", function(){

    var idCategoria = $(this).attr("id");
    var action = document.getElementById("action").value

    swal({
        title: '&iquest;&#x45;&#x73;&#x74;&aacute; seguro de Eliminar?',
        text: "¡Si no lo está puede cancelar la acción!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Si, Eliminar!'
    }).then(function(result){

        if(result.value){

            var form = document.createElement("form");
            var element1 = document.createElement("input");
            var element2 = document.createElement("input");
            var element3 = document.createElement("input");

            form.method = "POST";
            form.action = "/dashboard/productoActionAdd";

            element1.value=idCategoria;
            element1.name="codigo";
            form.appendChild(element1);

            element2.value="delete";
            element2.name="process";
            form.appendChild(element2);

            element3.value=action;
            element3.name="action";
            form.appendChild(element3);

            document.body.appendChild(form);

            form.submit();

        }

    })

})