package redSocial.redSocial.config;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import redSocial.redSocial.model.Administrador;
import redSocial.redSocial.repository.AdministradorRepository;

@Component
public class DataInitializer {

    private final AdministradorRepository administradorRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AdministradorRepository administradorRepository, PasswordEncoder passwordEncoder) {
        this.administradorRepository = administradorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct //Esto de aqui hace que spring ejecute esto automáticamente al iniciar la ejecución
    public void inicializar() {
        if (administradorRepository.findAdministradorByCorreo("admin@obregondice.com").isEmpty()) {
            Administrador administrador = new Administrador();
            administrador.setNombres("Administrador");
            administrador.setApellidos("Admin");
            administrador.setFecha_nacimiento(LocalDate.of(2000, 1, 1));
            administrador.setCorreo("admin@obregondice.com");
            administrador.setContrasenia(passwordEncoder.encode("Admin123"));

            administradorRepository.save(administrador);
            System.out.println("Administrador mock creado correctamente.");
        }
    }
}