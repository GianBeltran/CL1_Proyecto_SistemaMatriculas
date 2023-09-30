$(document).on("click", "#btnagregar", function(){
    $("#txtNombreProfe").val("");
    $("#txtApellidoProfe").val("");
    $("#txtCorreoProfe").val("");
    $("#hddcodprofe").val("0");

    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtNombreProfe").val($(this).attr("data-nomprofesor"));
    $("#txtApellidoProfe").val($(this).attr("data-apeprofesor"));
    $("#txtCorreoProfe").val($(this).attr("data-correo"));
    $("#hddcodprofe").val($(this).attr("data-idprofesor"));

    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/profesor/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            idprofesor: $("#hddcodprofe").val(),
            nomprofesor: $("#txtNombreProfe").val(),
            apeprofesor: $("#txtApellidoProfe").val(),
            correo: $("#txtCorreoProfe").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProfesores();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarProfesores(){
    $.ajax({
        type: "GET",
        url: "/profesor/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblprofesor > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblprofesor > tbody").append("<tr>"+
                    "<td>"+value.idprofesor+"</td>"+
                    "<td>"+value.nomprofesor+"</td>"+
                    "<td>"+value.apeprofesor+"</td>"+
                    "<td>"+value.correo+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idprofesor='"+value.idprofesor+"'"+
                                     "data-nomprofesor='"+value.nomprofesor+"'"+
                                     "data-apeprofesor='"+value.apeprofesor+"'"+
                                     "data-correo='"+value.correo+"'"+

                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}