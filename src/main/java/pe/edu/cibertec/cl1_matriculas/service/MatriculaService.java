package pe.edu.cibertec.cl1_matriculas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl1_matriculas.model.bd.Estudiante;
import pe.edu.cibertec.cl1_matriculas.model.bd.Matricula;
import pe.edu.cibertec.cl1_matriculas.model.request.MatriculaRequest;
import pe.edu.cibertec.cl1_matriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.cl1_matriculas.repository.MatriculaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MatriculaService {

    private MatriculaRepository matriculaRepository;

    public List<Matricula> listarMatriculas(){
        return matriculaRepository.findAll();
    }

    public ResultadoResponse guardarMatrícula(MatriculaRequest matricula){
        String mensaje = "Matrícula registrada correctamente";
        Boolean respuesta = true;
        try {
            Matricula objMatricula = new Matricula();
            if(matricula.getIdmatricula() > 0){
                objMatricula.setIdmatricula(matricula.getIdmatricula());
            }
            Estudiante estudiante = new Estudiante();
            estudiante.setIdestudiante(matricula.getIdestudiante());

            objMatricula.setEstudiante(estudiante);
            objMatricula.setYearacademico(matricula.getYearacademico());
            objMatricula.setFechmatric(matricula.getFechmatric());
            objMatricula.setEstadomatri(1);

            matriculaRepository.save(objMatricula);
        } catch (Exception e){
            mensaje = "Matrícula no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
}
