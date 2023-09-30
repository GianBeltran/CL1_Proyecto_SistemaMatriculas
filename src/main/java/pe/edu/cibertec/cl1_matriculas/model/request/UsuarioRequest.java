package pe.edu.cibertec.cl1_matriculas.model.request;

import lombok.Data;

@Data
public class UsuarioRequest {
    private Integer iduser;
    private String usuario;
    private String clave;
    private Integer idrol;
}
