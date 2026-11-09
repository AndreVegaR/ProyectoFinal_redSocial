package redSocial.redSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import redSocial.redSocial.model.Administrador;

public interface AdministradorController extends JpaRepository<Administrador, Long> {

// luego se meterán querys para lo del admin xd
}
