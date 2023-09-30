package pe.edu.cibertec.cl1_matriculas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.cl1_matriculas.model.bd.Usuario;
import pe.edu.cibertec.cl1_matriculas.model.request.UsuarioRequest;
import pe.edu.cibertec.cl1_matriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.cl1_matriculas.service.UsuarioService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaUsuarios", usuarioService.listarUsuarios());
        return "usuario/frmMantUsuario";
    }

    @ResponseBody
    @GetMapping("/listar")
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @ResponseBody
    @PostMapping("/guardar")
    public ResultadoResponse guardarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.guardarUsuario(usuarioRequest);
    }
}
