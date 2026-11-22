package redSocial.redSocial.config;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import redSocial.redSocial.model.*;
import redSocial.redSocial.repository.AdministradorRepository;
import redSocial.redSocial.repository.LugarRepository;
import redSocial.redSocial.repository.UsuarioRepository;

@Component
public class DataInitializer {

    private final AdministradorRepository administradorRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final LugarRepository lugarRepository;

    public DataInitializer(AdministradorRepository administradorRepository,
                           UsuarioRepository usuarioRepository,
                           LugarRepository lugarRepository,
                           PasswordEncoder passwordEncoder) {
        this.administradorRepository = administradorRepository;
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.lugarRepository = lugarRepository;
    }

    @PostConstruct //Esto de aqui hace que spring ejecute esto automáticamente al iniciar la ejecución
    public void inicializar() {
        inicializarAdmin();
        inicializarUsuarios();
        inicializarLugares();
    }

    private void inicializarAdmin() {
        if (administradorRepository.findAdministradorByCorreo("admin@obregondice.com").isEmpty()) {
            Administrador administrador = new Administrador();
            administrador.setNombres("Administrador");
            administrador.setApellidos("Admin");
            administrador.setNickname("Admincito");
            administrador.setFecha_nacimiento(LocalDate.of(2000, 1, 1));
            administrador.setCorreo("admin@obregondice.com");
            administrador.setContrasenia(passwordEncoder.encode("Admin123"));

            administradorRepository.save(administrador);
            System.out.println("Administrador mock creado correctamente.");
        }
    }

    private void inicializarUsuarios() {
        if (usuarioRepository.findAll().isEmpty()) {
            Usuario usuario1 = new Usuario();
            usuario1.setNombres("Juan Leonel");
            usuario1.setApellidos("Bojórquez Terán");
            usuario1.setNickname("leonel_66");
            usuario1.setFecha_nacimiento(LocalDate.of(2000, 1, 1));
            usuario1.setCorreo("juan@email.com");
            usuario1.setContrasenia(passwordEncoder.encode("johnlion"));
            usuarioRepository.save(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setNombres("Gamaliel");
            usuario2.setApellidos("Acuña Mendoza");
            usuario2.setNickname("gamota");
            usuario2.setFecha_nacimiento(LocalDate.of(2000, 1, 1));
            usuario2.setCorreo("gama@email.com");
            usuario2.setContrasenia(passwordEncoder.encode("soyelgamitaxd"));
            usuarioRepository.save(usuario2);
        }
    }

    private void inicializarLugares() {
        if (lugarRepository.findAll().isEmpty()) {
            Categoria categoria = new Categoria();
            categoria.setNombre("Restaurante");
            Direccion direccion = new Direccion();
            direccion.setCalle("Villas del Rey");
            direccion.setColonia("Villas del Rey");
            direccion.setNumero("670");
            direccion.setLatitud("27.4828");
            direccion.setLongitud("-109.9304");
            Lugar lugar1 = new Lugar();
            lugar1.setNombre("Hotdogs el Chapo");
            lugar1.setCategoria(categoria);
            lugar1.setDescripcion("Restaurante de hotdogs y hamburguesas");
            lugar1.setDireccion(direccion);
            lugar1.setImagenUrl("4QBoRXhpZgAASUkqAAgAAAACADEBAgAHAAAAJgAAAGmHBAABAAAALgAAAAAAAABQaWNhc2EAAAIAAJAHAAQAAAAwMjIwA5ACABQAAABMAAAAAAAAADIwMjA6MTI6MDcgMjE6NDA6NDcA");
            lugarRepository.save(lugar1);

            Categoria categoria2 = new Categoria();
            categoria2.setNombre("Decoración");
            Lugar lugar2 = new Lugar();
            lugar2.setNombre("La Laguna");
            lugar2.setCategoria(categoria2);
            lugar2.setDescripcion("Lugar para pasear y ver a los patos");
            lugar2.setDireccion(direccion);
            lugar2.setImagenUrl("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/7b/5f/f4/la-laguna-del-nainari.jpg?w=1200&h=1200&s=1");
            lugarRepository.save(lugar2);
        }
    }
}