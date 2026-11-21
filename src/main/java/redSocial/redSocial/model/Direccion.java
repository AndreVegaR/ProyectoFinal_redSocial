package redSocial.redSocial.model;

import jakarta.persistence.Column;
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
    @Column(nullable = false, length = 100)
    private String calle;

    @NotBlank(message = "El número exterior es obligatorio")
    @Size(max = 20, message = "El número es demasiado largo")
    @Column(nullable = false, length = 20)
    private String numero;

    @NotBlank(message = "La colonia no puede estar vacía")
    @Size(max = 100, message = "La colonia no puede superar los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String colonia;

    @Pattern(regexp = "^-?([1-8]?[0-9](\\.[0-9]+)?|90(\\.0+)?)$", message = "Latitud inválida")
    @Size(max = 30, message = "La latitud es demasiado larga")
    @Column(length = 30)
    private String latitud;

    @Pattern(regexp = "^-?(180(\\.0+)?|((1[0-7][0-9])|([1-9]?[0-9]))(\\.[0-9]+)?)$", message = "Longitud inválida")
    @Size(max = 30, message = "La longitud es demasiado larga")
    @Column(length = 30)
    private String longitud;
}