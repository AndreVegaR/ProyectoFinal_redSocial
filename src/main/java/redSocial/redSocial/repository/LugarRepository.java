package redSocial.redSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import redSocial.redSocial.model.Lugar;

import java.util.List;

public interface LugarRepository extends JpaRepository<Lugar, Long> {
    List<Lugar> findByNombreContainingIgnoreCase(String nombre);
}
