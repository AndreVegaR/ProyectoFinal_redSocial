package redSocial.redSocial.controller;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import redSocial.redSocial.dtos.LugarDTO;
import redSocial.redSocial.service.ResenaService;

@Controller
public class AdministradorController {

    @Autowired
    private ResenaService resenaService;
    /*
    @PostMapping("/admin/crear-lugar/guardar")
    public String guardarLugar(@RequestBody LugarDTO lugardto,
                               @RequestParam("imagen") MultipartFile imagen){


    }
    */


    @PostMapping("/admin/resenas/moderar")
    public String moderarResena(@RequestParam("resenaId") Long resenaId,
                                @RequestParam("lugarId") Long lugarId,
                                @RequestParam("justificacion") String justificacion) {
        resenaService.moderarResena(resenaId, justificacion);
        return "redirect:/admin/lugares/" + lugarId;
    }
}
