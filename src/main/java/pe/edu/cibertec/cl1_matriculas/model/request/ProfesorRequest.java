package pe.edu.cibertec.cl1_matriculas.model.request;

import lombok.Data;

@Data
public class ProfesorRequest {
    private Integer idprofesor;
    private String nomprofesor;
    private String apeprofesor;
    private String correo;
}
