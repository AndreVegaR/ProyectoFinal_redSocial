package redSocial.redSocial.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redSocial.redSocial.dtos.AdministradorDTO;
import redSocial.redSocial.service.CuentaService;

/**
 * Controlador de autenticación.
 * Para el registro e inicio de sesión.
 */
@Controller
public class AuthController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/inicio-sesion")
    public String procesarLogin(@RequestParam("correo") String correo,
                                @RequestParam("contrasenia") String contrasenia,
                                Model modelo,
                                HttpSession session){

        AdministradorDTO admin = cuentaService.autentificarCuenta(correo, contrasenia);

        if(admin != null){
            // para este punto esto es necesario para guardar quién es la persona
            session.setAttribute("admin_id", admin.getId());

            // patrón PRG  q es (post, redirect, get)
            return "redirect:/feed-admin";
        }else{
            modelo.addAttribute("error", "Credencial inválida. Intentalo nuevamente.");
            return "inicio-sesion";
        }
    }

    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession sesion){
        sesion.invalidate();
        return "redirect:/";
    }
}
