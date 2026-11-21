package redSocial.redSocial.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lugares")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del lugar es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    @Column(length = 500)
    private String descripcion;

    @DecimalMin(value = "0.0", message = "La calificación no puede ser menor a 0")
    @DecimalMax(value = "5.0", message = "La calificación no puede ser mayor a 5")
    @Column(name = "calificacion_promedio", nullable = false)
    private double calificacionPromedio;

    @Size(max = 255, message = "La URL de la imagen es demasiado larga")
    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Estado estado = Estado.ACTIVO;

    @NotNull(message = "Debes seleccionar una categoría")
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Valid
    @NotNull(message = "La dirección es obligatoria")
    @Embedded
    private Direccion direccion;

    @OneToMany(mappedBy = "lugar")
    private List<Resena> resenas = new ArrayList<>();
}