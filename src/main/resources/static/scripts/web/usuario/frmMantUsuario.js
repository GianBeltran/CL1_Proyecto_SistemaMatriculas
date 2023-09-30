$(document).on("click", "#btnagregar", function(){
    $("#txtUsuario").val("");
    $("#txtClave").val("");
    $("#hddcodusu").val("0");
    $("#cboroles").empty();

    listarCboRoles();
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtUsuario").val($(this).attr("data-usuario"));
    $("#txtClave").val($(this).attr("data-clave"));
    $("#hddcodusu").val($(this).attr("data-iduser"));
    $("#cboroles").empty();
    listarCboRoles($(this).attr("data-idrol"));
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/usuario/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            iduser: $("#hddcodusu").val(),
            usuario: $("#txtUsuario").val(),
            clave: $("#txtClave").val(),
            idrol: $("#cboroles").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarUsuarios();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

function listarCboRoles(idrol){
    $.ajax({
        type: "GET",
        url: "/rol/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboroles").append(
                    `<option value="${value.idrol}">${value.nomrol}</option>`
                )
            });
            if(idrol > 0){
                $("#cboroles").val(idrol);
            }
        }
    });
}

function listarUsuarios(){
    $.ajax({
        type: "GET",
        url: "/usuario/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblusuario > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblusuario > tbody").append("<tr>"+
                    "<td>"+value.iduser+"</td>"+
                    "<td>"+value.usuario+"</td>"+
                    "<td>"+value.clave+"</td>"+
                    "<td>"+value.rol.nomrol+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-iduser='"+value.iduser+"'"+
                                     "data-usuario='"+value.usuario+"'"+
                                     "data-clave='"+value.clave+"'"+
                                     "data-idrol='"+value.rol.idrol+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}