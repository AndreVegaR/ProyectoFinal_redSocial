package redSocial.redSocial.controller;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import redSocial.redSocial.dtos.LugarDTO;

@Controller
public class AdministradorController {


    @PostMapping("/admin/crear-lugar/guardar")
    public String guardarLugar(@RequestBody LugarDTO lugardto,
                               @RequestParam("imagen") MultipartFile imagen){


    }
}
