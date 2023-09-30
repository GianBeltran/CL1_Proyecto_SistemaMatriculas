package pe.edu.cibertec.cl1_matriculas.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class PagosRequest {
    private Integer idpago;
    private Integer idmatricula;
    private Date fechapago;
    private Double montopago;
    private Integer estadopago;
}
