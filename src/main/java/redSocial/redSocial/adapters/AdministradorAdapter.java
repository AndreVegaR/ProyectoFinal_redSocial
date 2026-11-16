package redSocial.redSocial.adapters;

import redSocial.redSocial.bos.AdministradorBO;
import redSocial.redSocial.dtos.AdministradorDTO;
import redSocial.redSocial.model.Administrador;

public class AdministradorAdapter {

    public static AdministradorBO entity_a_bo(Administrador administrador) {
        if (administrador == null) {
            return null;
        }

        return new AdministradorBO(
                administrador.getId(),
                administrador.getNombres(),
                administrador.getApellidos(),
                administrador.getFecha_nacimiento(),
                administrador.getCorreo(),
                administrador.getContrasenia()
        );
    }

    public static AdministradorDTO bo_a_dto(AdministradorBO administradorBO) {
        if (administradorBO == null) {
            return null;
        }

        return new AdministradorDTO(
                administradorBO.getId(),
                administradorBO.getNombres(),
                administradorBO.getApellidos(),
                administradorBO.getCorreo()
        );
    }

    public static Administrador dto_a_entidad(AdministradorDTO administradorDTO) {
        if (administradorDTO == null) {
            return null;
        }

        Administrador administrador = new Administrador();

        administrador.setId(administradorDTO.getId());
        administrador.setNombres(administradorDTO.getNombres());
        administrador.setApellidos(administradorDTO.getApellidos());
        administrador.setCorreo(administradorDTO.getCorreo());

        return administrador;
    }
}
