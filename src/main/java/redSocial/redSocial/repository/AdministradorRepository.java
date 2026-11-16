package redSocial.redSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import redSocial.redSocial.model.Administrador;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    // Buscar por correo, para iniciar sesión
    Optional<Administrador> findAdministradorByCorreo(String correo);

}
