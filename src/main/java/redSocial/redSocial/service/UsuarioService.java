package redSocial.redSocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redSocial.redSocial.model.Estado;
import redSocial.redSocial.model.Usuario;
import redSocial.redSocial.repository.UsuarioRepository;
import java.util.List;

@Service
public class  UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Filtra los usuarios por nickname
     *
     * @param nickname
     *
     * @return
     */
    public List<Usuario> consultarUsuariosNickname(String nickname) {
        if (nickname != null && !nickname.isBlank()) {
            return usuarioRepository.findByNicknameContainingIgnoreCase(nickname);
        }
        return usuarioRepository.findAll();
    }

    /**
     * Consulta todos los usuarios
     *
     * @return
     */
    public List<Usuario> consultarUsuariosActivos() {
        return usuarioRepository.findByEstado(Estado.ACTIVO);
    }

    public void deshabilitarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        usuario.setEstado(Estado.INACTIVO);
        usuarioRepository.save(usuario);
    }

    public void habilitarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        usuario.setEstado(Estado.ACTIVO);
        usuarioRepository.save(usuario);
    }
}
