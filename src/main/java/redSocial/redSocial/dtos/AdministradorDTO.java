package redSocial.redSocial.dtos;

import lombok.Data;

@Data
public class AdministradorDTO {

    private Long id;

    private String nombres;

    private String apellidos;

    private String correo;

    public AdministradorDTO(Long id, String nombres, String apellidos, String correo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }
}
