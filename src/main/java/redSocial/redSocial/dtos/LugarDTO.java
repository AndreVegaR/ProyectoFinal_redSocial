package redSocial.redSocial.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import redSocial.redSocial.model.Categoria;

@Data
public class LugarDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "Descripción es obligatorio")
    private String descripcion;

    private String imagenUrl;

    @NotBlank(message = "categoría es obligatorio")
    private Categoria categoria;

    @NotBlank(message = "calle es obligatorio")
    private String calle;

    @NotBlank(message = "El número exterior es obligatorio")
    private String numero;

    @NotBlank(message = "La colonia no puede estar vacía")
    private String colonia;

    @Pattern(regexp = "^-?([1-8]?[0-9](\\.[0-9]+)?|90(\\.0+)?)$", message = "Latitud inválida")
    private String latitud;

    @Pattern(regexp = "^-?(180(\\.0+)?|((1[0-7][0-9])|([1-9]?[0-9]))(\\.[0-9]+)?)$", message = "Longitud inválida")
    private String longitud;
}
