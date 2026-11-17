package redSocial.redSocial.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion {

    private String calle;
    private String numero;
    private String colonia;
    private String longitud;
    private String latitud;
}

