package redSocial.redSocial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "cuenta_id")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) // PARA COMPARAR UN ADMIN CON OTRO, COMPARA ATRIBUTOS HEREDADODS
public class Administrador extends Cuenta{
}
