package redSocial.redSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import redSocial.redSocial.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
