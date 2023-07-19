package co.edu.iudigital.helpmeiud.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CasoRequest {
    LocalDateTime fechaHora;

    Float latitud;

    Float longitud;

    Float altitud;

    String descripcion;

    Boolean esVisble;

    String urlMap;

    String rmiUrl;

    Long usuarioId;

    Long delitoId;
}
