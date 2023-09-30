$(document).on("click", "#btnagregar", function(){
    $("#txtNombreEstu").val("");
    $("#txtApellidoEstu").val("");
    $("#txtFechaEstu").val("");
    $("#txtDireccionEstu").val("");
    $("#txtCorreoEstu").val("");
    $("#txtTelefonoEstu").val("");
    $("#txtGradoEstu").val("");
    $("#hddcodestu").val("0");

    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtNombreEstu").val($(this).attr("data-nomestudiante"));
    $("#txtApellidoEstu").val($(this).attr("data-apeestudiante"));
    $("#txtFechaEstu").val($(this).attr("data-fechanac"));
    $("#txtDireccionEstu").val($(this).attr("data-direccion"));
    $("#txtCorreoEstu").val($(this).attr("data-correo"));
    $("#txtTelefonoEstu").val($(this).attr("data-telefono"));
    $("#txtGradoEstu").val($(this).attr("data-grado"));
    $("#hddcodestu").val($(this).attr("data-idestudiante"));

    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/estudiante/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            idestudiante: $("#hddcodestu").val(),
            nomestudiante: $("#txtNombreEstu").val(),
            apeestudiante: $("#txtApellidoEstu").val(),
            fechanac: $("#txtFechaEstu").val(),
            direccion: $("#txtDireccionEstu").val(),
            correo: $("#txtCorreoEstu").val(),
            telefono: $("#txtTelefonoEstu").val(),
            grado: $("#txtGradoEstu").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarEstudiantes();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarEstudiantes(){
    $.ajax({
        type: "GET",
        url: "/estudiante/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblestudiante > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblestudiante > tbody").append("<tr>"+
                    "<td>"+value.idestudiante+"</td>"+
                    "<td>"+value.nomestudiante+"</td>"+
                    "<td>"+value.apeestudiante+"</td>"+
                    "<td>"+value.fechanac+"</td>"+
                    "<td>"+value.direccion+"</td>"+
                    "<td>"+value.correo+"</td>"+
                    "<td>"+value.telefono+"</td>"+
                    "<td>"+value.grado+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idestudiante='"+value.idestudiante+"'"+
                                     "data-nomestudiante='"+value.nomestudiante+"'"+
                                     "data-apeestudiante='"+value.apeestudiante+"'"+
                                     "data-fechanac='"+value.fechanac+"'"+
                                     "data-direccion='"+value.direccion+"'"+
                                     "data-correo='"+value.correo+"'"+
                                     "data-telefono='"+value.telefono+"'"+
                                     "data-grado='"+value.grado+"'"+

                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}