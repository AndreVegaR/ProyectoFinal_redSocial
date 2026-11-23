package redSocial.redSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redSocial.redSocial.dtos.LugarDTO;
import redSocial.redSocial.model.Lugar;
import redSocial.redSocial.repository.CategoriaRepository;
import redSocial.redSocial.service.CategoriaService;
import redSocial.redSocial.service.LugarService;
import redSocial.redSocial.service.UsuarioService;

import java.io.IOException;

/*
Controlador de navegación
*/
@Controller
public class RedController {

    @Autowired
    private LugarService lugarService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio() {
        return "inicio-sesion";
    }

    @GetMapping("/inicio-sesion")
    public String mostrarInicioSesion() {
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
        model.addAttribute("lugar", lugarService.buscarPorId(id));
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "crear-lugar";
    }

    @PostMapping("/admin/lugares/editar/{id}")
    public String actualizarLugar(@PathVariable Long id,
                                  @ModelAttribute LugarDTO lugardto,
                                  @RequestParam(value = "imagen", required = false) MultipartFile imagen)
            throws IOException {

        lugarService.actualizarLugar(id, lugardto, imagen);
        return "redirect:/admin/lugares/" + id;
    }

    @GetMapping("/admin/categorias")
    public String mostrarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "gestionar-categoria";
    }

    @GetMapping("/admin/gestion-usuarios")
    public String mostrarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.consultarTodosLosUsuarios());
        return "gestion-usuarios";
    }

    @GetMapping("/admin/usuarios/{id}")
    public String mostrarDetalleUsuarioAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "admin-perfil-usuario";
    }
}
