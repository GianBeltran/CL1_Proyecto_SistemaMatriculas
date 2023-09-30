package pe.edu.cibertec.cl1_matriculas.model.request;

import lombok.Data;
import java.util.Date;

@Data
public class EstudianteRequest {
    private Integer idestudiante;
    private String nomestudiante;
    private String apeestudiante;
    private Date fechanac;
    private String direccion;
    private String correo;
    private String telefono;
    private String grado;
}
