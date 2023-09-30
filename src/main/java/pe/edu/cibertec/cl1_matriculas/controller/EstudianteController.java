package pe.edu.cibertec.cl1_matriculas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.cl1_matriculas.model.bd.Estudiante;
import pe.edu.cibertec.cl1_matriculas.model.request.EstudianteRequest;
import pe.edu.cibertec.cl1_matriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.cl1_matriculas.service.EstudianteService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/estudiante")
public class EstudianteController {

    private EstudianteService estudianteService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaEstudiantes", estudianteService.listarEstudiantes());
        return "estudiante/frmMantEstudiante";
    }

    @ResponseBody
    @GetMapping("/listar")
    public List<Estudiante> listarEstudiantes(){
        return estudianteService.listarEstudiantes();
    }

    @ResponseBody
    @PostMapping("/guardar")
    public ResultadoResponse guardarEstudiante(@RequestBody EstudianteRequest estudianteRequest){
        return estudianteService.guardarEstudiante(estudianteRequest);
    }

}
