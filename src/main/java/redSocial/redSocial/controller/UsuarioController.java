package redSocial.redSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redSocial.redSocial.model.Usuario;
import redSocial.redSocial.service.UsuarioService;

import java.util.List;

@Controller
@RequestMapping("/admin/metricas")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(
            @RequestParam(name = "buscador", required = false) String nickname,
            Model model) {

        List<Usuario> usuarios;

        if (nickname != null && !nickname.isBlank()) {
            usuarios = usuarioService.consultarUsuariosNickname(nickname);
        } else {
            usuarios = usuarioService.consultarUsuariosActivos();
        }

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("busquedaActual", nickname);

        return "metricas";
    }

    /**
     * Deshabilita un usuario por su ID.
     */
    @PostMapping("/{id}/deshabilitar")
    public String deshabilitarUsuario(@PathVariable Long id) {
        usuarioService.deshabilitarUsuario(id);
        return "redirect:/admin/metricas";
    }

    /**
     * Habilita un usuario por su ID.
     */
    @PostMapping("/{id}/habilitar")
    public String habilitarUsuario(@PathVariable Long id) {
        usuarioService.habilitarUsuario(id);
        return "redirect:/admin/metricas";
    }
}