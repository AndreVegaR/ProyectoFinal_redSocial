package redSocial.redSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import redSocial.redSocial.service.CuentaService;

/**
 * Controlador de autenticación.
 * Para el registro e inicio de sesión.
 */
@Controller
public class AuthController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/login")
    public String mostrarLogin(){

        // como para mostrar login no se necesitan
        // cargar datos, no se ocupa PRG.
        return "login";
    }

    // ya no le seguí, mejor hago thymeleaf xd
}
