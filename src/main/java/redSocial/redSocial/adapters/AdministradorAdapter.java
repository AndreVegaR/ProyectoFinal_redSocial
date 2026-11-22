package redSocial.redSocial.adapters;

import redSocial.redSocial.dtos.AdministradorDTO;
import redSocial.redSocial.model.Administrador;

public class AdministradorAdapter {

    public static AdministradorDTO entity_a_dto(Administrador administrador) {
        if (administrador == null) {
            return null;
        }

        return new AdministradorDTO(
                administrador.getId(),
                administrador.getNombres(),
                administrador.getApellidos(),
                administrador.getCorreo()
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
