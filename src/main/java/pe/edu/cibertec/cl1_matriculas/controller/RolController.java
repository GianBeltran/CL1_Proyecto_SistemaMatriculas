package pe.edu.cibertec.cl1_matriculas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.cl1_matriculas.model.bd.Rol;
import pe.edu.cibertec.cl1_matriculas.model.request.RolRequest;
import pe.edu.cibertec.cl1_matriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.cl1_matriculas.service.RolService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/rol")
public class RolController {

    private RolService rolService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaRoles", rolService.listarRoles());
        return "rol/frmMantRol";
    }

    @ResponseBody
    @GetMapping("/listar")
    public List<Rol> listarRoles(){
        return rolService.listarRoles();
    }

    @ResponseBody
    @PostMapping("/guardar")
    public ResultadoResponse guardarRol(@RequestBody RolRequest rolRequest){
        return rolService.guardarRol(rolRequest);
    }
}
