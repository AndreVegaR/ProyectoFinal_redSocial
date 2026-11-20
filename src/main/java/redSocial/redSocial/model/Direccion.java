package redSocial.redSocial.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion {

    @NotBlank(message = "La calle no puede estar vacía")
    @Size(max = 100, message = "La calle no puede superar los 100 caracteres")
    private String calle;

    @NotBlank(message = "El número exterior es obligatorio")
    @Size(max = 20, message = "El número es demasiado largo")
    private String numero;

    @NotBlank(message = "La colonia no puede estar vacía")
    @Size(max = 100, message = "La colonia no puede superar los 100 caracteres")
    private String colonia;

    @Pattern(regexp = "^-?([1-8]?[0-9](\\.[0-9]+)?|90(\\.0+)?)$", message = "Latitud inválida")
    private String latitud;

    @Pattern(regexp = "^-?(180(\\.0+)?|((1[0-7][0-9])|([1-9]?[0-9]))(\\.[0-9]+)?)$", message = "Longitud inválida")
    private String longitud;
}

