package pe.edu.cibertec.cl1_matriculas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl1_matriculas.model.bd.Estudiante;
import pe.edu.cibertec.cl1_matriculas.model.request.EstudianteRequest;
import pe.edu.cibertec.cl1_matriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.cl1_matriculas.repository.EstudianteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EstudianteService {

    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarEstudiantes(){
        return estudianteRepository.findAll();
    }

    public ResultadoResponse guardarEstudiante(EstudianteRequest estudiante){
        String mensaje = "Estudiante registrado correctamente";
        Boolean respuesta = true;
        try {
            Estudiante objEstudiante = new Estudiante();
            if(estudiante.getIdestudiante() > 0){
                objEstudiante.setIdestudiante(estudiante.getIdestudiante());
            }
            objEstudiante.setNomestudiante(estudiante.getNomestudiante());
            objEstudiante.setApeestudiante(estudiante.getApeestudiante());
            objEstudiante.setFechanac(estudiante.getFechanac());
            objEstudiante.setDireccion(estudiante.getDireccion());
            objEstudiante.setCorreo(estudiante.getCorreo());
            objEstudiante.setTelefono(estudiante.getTelefono());
            objEstudiante.setGrado(estudiante.getGrado());

            estudianteRepository.save(objEstudiante);
        } catch (Exception e){
            mensaje = "Estudiante no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
}
