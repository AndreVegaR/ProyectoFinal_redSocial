package redSocial.redSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import redSocial.redSocial.model.Estado;
import redSocial.redSocial.model.Lugar;
import redSocial.redSocial.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNicknameContainingIgnoreCase(String nickname);

    List<Usuario> findByNicknameContainingIgnoreCaseAndEstado(String nickname, Estado estado);

    List<Usuario> findByEstado(Estado estado);
}