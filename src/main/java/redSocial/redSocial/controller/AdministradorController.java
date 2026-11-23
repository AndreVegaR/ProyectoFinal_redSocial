package redSocial.redSocial.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import redSocial.redSocial.dtos.LugarDTO;
import redSocial.redSocial.model.Categoria;
import redSocial.redSocial.service.CategoriaService;
import redSocial.redSocial.service.LugarService;
import redSocial.redSocial.service.ResenaService;

@Controller
public class AdministradorController {

    @Autowired
    private ResenaService resenaService;

    @Autowired
    private LugarService lugarService;

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/admin/crear-lugar/guardar")
    public String guardarLugar(@ModelAttribute LugarDTO lugardto,
                               @RequestParam("imagen") MultipartFile imagen) {
        try {
            Long id = lugarService.registrarLugar(lugardto, imagen);
            return "redirect:/admin/lugares/" + id;
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/crear-lugar";
        }
    }


    @PostMapping("/admin/resenas/moderar")
    public String moderarResena(@RequestParam("resenaId") Long resenaId,
                                @RequestParam("lugarId") Long lugarId,
                                @RequestParam("justificacion") String justificacion) {
        resenaService.moderarResena(resenaId, justificacion);
        return "redirect:/admin/lugares/" + lugarId;
    }


    @PostMapping("/admin/editar-categoria")
    public String editarCategoria(@Valid @ModelAttribute Categoria categoria) {
        categoriaService.actualizarCategoria(categoria.getId(), categoria.getNombre());
        return "redirect:/admin/categorias";
    }

    @PostMapping("/admin/crear-categoria")
    public String crearCategoria(@Valid @ModelAttribute Categoria categoria){
        categoriaService.guardarCategoria(categoria);
        return "redirect:/admin/categorias";
    }

    @PostMapping("/admin/eliminar-categoria")
    public String eliminarCategoria(@ModelAttribute Categoria categoria){
        categoriaService.eliminarCategoria(categoria.getId());
        return "redirect:/admin/categorias";
    }

}
