package redSocial.redSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import redSocial.redSocial.model.Lugar;
import redSocial.redSocial.repository.CategoriaRepository;
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

    @GetMapping("/admin/lugares/{id}")
    public String mostrarDetalleLugarAdmin(@PathVariable Long id, Model model) { 
        Lugar lugar = lugarService.buscarPorId(id);

        model.addAttribute("lugar", lugar);
        model.addAttribute("categorias", categoriaService.listarTodas());

        return "lugar-admin";
    }

    @GetMapping("/admin/crear-lugar")
    public String mostrarCrearLugar(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "crear-lugar";
    }

    @GetMapping("/admin/lugares/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Lugar lugar = lugarService.buscarPorId(id);
        model.addAttribute("lugar", lugar);
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "crear-lugar";
    }

    @GetMapping("/admin/categorias")
    public String mostrarCategorias(Model model){
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "gestionar-categoria";
    }
}
