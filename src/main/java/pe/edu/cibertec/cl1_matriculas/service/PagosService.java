package pe.edu.cibertec.cl1_matriculas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl1_matriculas.model.bd.Matricula;
import pe.edu.cibertec.cl1_matriculas.model.bd.Pagos;
import pe.edu.cibertec.cl1_matriculas.model.request.PagosRequest;
import pe.edu.cibertec.cl1_matriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.cl1_matriculas.repository.PagosRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PagosService {

    private PagosRepository pagosRepository;

    public List<Pagos> listarPagos(){
        return pagosRepository.findAll();
    }

    public ResultadoResponse guardarPago(PagosRequest pago){
        String mensaje = "Pago registrado correctamente";
        Boolean respuesta = true;
        try{
            Pagos objPago = new Pagos();
            if(pago.getIdpago() > 0){
                objPago.setIdpago(pago.getIdpago());
            }
            Matricula matricula = new Matricula();
            matricula.setIdmatricula(pago.getIdmatricula());

            objPago.setMatricula(matricula);
            objPago.setFechapago(pago.getFechapago());
            objPago.setMontopago(pago.getMontopago());
            objPago.setEstadopago(1);

            pagosRepository.save(objPago);
        } catch (Exception e){
            mensaje = "Pago no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
}
