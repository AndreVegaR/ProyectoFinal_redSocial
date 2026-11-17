package redSocial.redSocial.model;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(name = "calificacion_promedio")
    private double calificacionPromedio;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.ACTIVO;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Embedded
    private Direccion direccion;

    @OneToMany(mappedBy = "lugar")
    private List<Resena> resenas = new ArrayList<>();
}
