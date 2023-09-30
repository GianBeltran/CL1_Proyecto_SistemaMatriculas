package pe.edu.cibertec.cl1_matriculas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectomatriculas.model.bd.Rol;
import pe.edu.cibertec.proyectomatriculas.model.request.RolRequest;
import pe.edu.cibertec.proyectomatriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.proyectomatriculas.repository.RolRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RolService {

    private RolRepository rolRepository;

    public List<Rol> listarRoles(){
        return rolRepository.findAll();
    }

    public ResultadoResponse guardarRol(RolRequest rol){
        String mensaje = "Rol registrado correctamente";
        Boolean respuesta = true;
        try {
            Rol objRol = new Rol();
            if(rol.getIdrol() > 0){
                objRol.setIdrol(rol.getIdrol());
            }
            objRol.setNomrol(rol.getNomrol());

            rolRepository.save(objRol);
        }catch (Exception e){
            mensaje = "Rol no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
}
