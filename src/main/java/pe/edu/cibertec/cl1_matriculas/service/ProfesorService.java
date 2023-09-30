package pe.edu.cibertec.cl1_matriculas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl1_matriculas.model.bd.Profesor;
import pe.edu.cibertec.cl1_matriculas.model.request.ProfesorRequest;
import pe.edu.cibertec.cl1_matriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.cl1_matriculas.repository.ProfesorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfesorService {

    private ProfesorRepository profesorRepository;

    public List<Profesor> listarProfesores(){
        return profesorRepository.findAll();
    }

    public ResultadoResponse guardarProfesor(ProfesorRequest profesor){
        String mensaje = "Profesor registrado correctamente";
        Boolean respuesta = true;
        try{
            Profesor objProfesor = new Profesor();
            if(profesor.getIdprofesor() > 0){
                objProfesor.setIdprofesor(profesor.getIdprofesor());
            }
            objProfesor.setNomprofesor(profesor.getNomprofesor());
            objProfesor.setApeprofesor(profesor.getApeprofesor());
            objProfesor.setCorreo(profesor.getCorreo());

            profesorRepository.save(objProfesor);
        } catch (Exception e){
            mensaje = "Profesor no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
}
