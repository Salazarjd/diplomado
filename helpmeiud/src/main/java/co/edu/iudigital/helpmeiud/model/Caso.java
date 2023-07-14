package co.edu.iudigital.helpmeiud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "casos")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Caso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "fecha_hora", nullable = false)
    LocalDateTime fechaHora;

    @Column
    Float latitud;

    @Column
    Float longitud;

    @Column
    Float altitud;

    @Column
    String descripcion;

    @Column(name = "es_visible")
    Boolean esVisble;

    @Column(name = "url_map")
    String urlMap;

    @Column(name = "rmi_url")
    String rmiUrl;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "delitos_id")
    Delito delito;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(fechaHora)) {
            fechaHora = LocalDateTime.now();
        }
    }

}
