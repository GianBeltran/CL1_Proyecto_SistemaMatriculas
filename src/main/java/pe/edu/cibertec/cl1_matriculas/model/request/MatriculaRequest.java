package pe.edu.cibertec.cl1_matriculas.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class MatriculaRequest {
    private Integer idmatricula;
    private Integer idestudiante;
    private Integer yearacademico;
    private Date fechmatric;
    private Integer estadomatri;
}
