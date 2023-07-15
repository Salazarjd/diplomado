package co.edu.iudigital.helpmeiud.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DelitoDTORequest {
    @NotNull(message = "Nombre no puede ser nulo")
    @NotEmpty(message = "Nombre no puede estar vacio")
    String nombre;
    String descripcion;
    @NotNull(message = "Debe proporcionar le ID del usuario")
    Long usuarioId;
}
