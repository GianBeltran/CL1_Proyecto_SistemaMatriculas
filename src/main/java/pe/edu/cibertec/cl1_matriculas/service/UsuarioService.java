package pe.edu.cibertec.cl1_matriculas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectomatriculas.model.bd.Rol;
import pe.edu.cibertec.proyectomatriculas.model.bd.Usuario;
import pe.edu.cibertec.proyectomatriculas.model.request.UsuarioRequest;
import pe.edu.cibertec.proyectomatriculas.model.response.ResultadoResponse;
import pe.edu.cibertec.proyectomatriculas.repository.UsuarioRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public ResultadoResponse guardarUsuario(UsuarioRequest usuario){
        String mensaje = "Usuario registrado correctamente";
        Boolean respuesta = true;
        try{
            Usuario objUsuario = new Usuario();
            if(usuario.getIduser() > 0){
                objUsuario.setIduser(usuario.getIduser());
            }
            objUsuario.setUsuario(usuario.getUsuario());
            objUsuario.setClave(usuario.getClave());

            Rol rol = new Rol();
            rol.setIdrol(usuario.getIdrol());
            objUsuario.setRol(rol);

            usuarioRepository.save(objUsuario);
        } catch (Exception e){
            mensaje = "Usuario no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
}
