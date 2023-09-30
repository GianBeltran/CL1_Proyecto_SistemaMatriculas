$(document).on("click", "#btnagregar", function(){
    $("#txtNombreRol").val("");
    $("#hddcodrol").val("0");

    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtNombreRol").val($(this).attr("data-nomrol"));
    $("#hddcodrol").val($(this).attr("data-idrol"));

    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/rol/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            idrol: $("#hddcodrol").val(),
            nomrol: $("#txtNombreRol").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarRoles();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarRoles(){
    $.ajax({
        type: "GET",
        url: "/rol/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblrol > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblrol > tbody").append("<tr>"+
                    "<td>"+value.idrol+"</td>"+
                    "<td>"+value.nomrol+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idrol='"+value.idrol+"'"+
                                     "data-nomrol='"+value.nomrol+"'"+

                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}