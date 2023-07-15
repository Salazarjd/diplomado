package co.edu.iudigital.helpmeiud.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsuarioDTORequest {
    @NotBlank(message = "username obligatorio")
    @Email
    String username;

    @NotBlank(message = "nombre obligatorio")
    String nombre;

    String apellido;

    @Size(min = 5, message = "Debe munistrar una contraseña segura")
    String password;

    Boolean redSocial;

    @DateTimeFormat
    LocalDate fechaNacimiento;

    Boolean enabled;

    String image;
}
