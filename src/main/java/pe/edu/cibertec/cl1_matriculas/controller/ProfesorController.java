package pe.edu.cibertec.cl1_matriculas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.cl1_matriculas.model.bd.Profesor;
import pe.edu.cibertec.cl1_matriculas.model.request.ProfesorRequest;
import pe.edu.cibertec.cl1_matriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.cl1_matriculas.service.ProfesorService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/profesor")
public class ProfesorController {

    private ProfesorService profesorService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaProfesores", profesorService.listarProfesores());
        return "profesor/frmMantProfesor";
    }

    @ResponseBody
    @GetMapping("/listar")
    public List<Profesor> listarProfesores(){
        return profesorService.listarProfesores();
    }

    @ResponseBody
    @PostMapping("/guardar")
    public ResultadoResponse guardarProfesor(@RequestBody ProfesorRequest profesorRequest){
        return profesorService.guardarProfesor(profesorRequest);
    }
}
