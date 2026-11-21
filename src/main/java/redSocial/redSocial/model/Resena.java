package redSocial.redSocial.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "La calificación mínima es 1")
    @Max(value = 5, message = "La calificación máxima es 5")
    @Column(nullable = false)
    private int calificacion;

    @NotBlank(message = "El comentario de la reseña es obligatorio")
    @Size(min = 5, max = 1000, message = "La reseña debe tener entre 5 y 1000 caracteres")
    @Column(nullable = false, length = 1000)
    private String texto;

    @NotBlank(message = "La fecha es obligatoria")
    @Size(max = 50, message = "La fecha no puede superar los 50 caracteres")
    @Column(nullable = false, length = 50)
    private String fecha;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Estado estado = Estado.ACTIVO;

    @NotNull(message = "El usuario es obligatorio")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull(message = "El lugar es obligatorio")
    @ManyToOne
    @JoinColumn(name = "lugar_id", nullable = false)
    private Lugar lugar;
}