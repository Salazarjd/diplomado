package co.edu.iudigital.helpmeiud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usuarios")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username",
            unique = true,
            length = 120,
            nullable = false)
    String username;

    @Column(name = "nombre", nullable = false, length = 120)
    String nombre;

    @Column(name = "apellido", length = 120)
    String apellido;

    @Column(name = "password")
    String password;

    @Column
    Boolean redSocial;

    @Column(name = "fecha_nacimiento")
    LocalDate fechaNacimiento;

    @Column
    Boolean enabled;

    @Column
    String image;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_usuarios",
            joinColumns = {@JoinColumn(name = "usuarios_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")}
    )
    List<Role> roles;
}
