package redSocial.redSocial.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "seguidos")
@ToString(exclude = "seguidos")
@Entity
@Table(name = "usuarios")
@PrimaryKeyJoinColumn(name = "cuenta_id")
public class Usuario extends Cuenta {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.ACTIVO;

    @Size(max = 255, message = "La URL de la imagen es demasiado larga")
    @Column(name = "fotoPerfil", length = 255)
    private String fotoPerfil;

    @ManyToMany
    @JoinTable(
            name = "usuario_seguidores",
            joinColumns = @JoinColumn(name = "seguidor_id"),
            inverseJoinColumns = @JoinColumn(name = "seguido_id")
    )
    private Set<Usuario> seguidos = new HashSet<>();
}
