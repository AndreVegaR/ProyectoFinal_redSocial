package redSocial.redSocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
Controlador de navegación
*/
@Controller
public class RedController {

    @GetMapping("/")
    public String inicio(){
        return "inicio-sesion";
    }

    @GetMapping("/inicio-sesion")
    public String mostrarInicioSesion(){
        return "inicio-sesion";
    }

    @GetMapping("/feed-admin")
    public String mostrarFeedAdmin() {
        return "feed-admin";
    }

    @GetMapping("/Feed-principal-usuario")
    public String mostrarFeedUsuario() {
        return "Feed-principal-usuario";
    }
}