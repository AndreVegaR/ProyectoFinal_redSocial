package redSocial.redSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redSocial.redSocial.service.CategoriaService;
import redSocial.redSocial.service.LugarService;

/*
Controlador de navegación
*/
@Controller
public class RedController {

    @Autowired
    private LugarService lugarService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String inicio(){
        return "inicio-sesion";
    }

    @GetMapping("/inicio-sesion")
    public String mostrarInicioSesion(){
        return "inicio-sesion";
    }

    @GetMapping("/feed-admin")
    public String mostrarFeedAdmin(@RequestParam(required = false) String busqueda, Model model) {
        model.addAttribute("lugares", lugarService.listarLugares(busqueda));
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "feed-admin";
    }

    @GetMapping("/Feed-principal-usuario")
    public String mostrarFeedUsuario() {
        return "Feed-principal-usuario";
    }
}