package EaseMood.com.api.DTO;

import EaseMood.com.api.DTO.annotation.UniqueEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDTO {

    private int id;

    @NotNull(message = "firstname cannot be null")
    private String firstName;

    @NotNull(message = "lastname cannot be null")
    private String lastName;

    @NotNull(message = "password cannot be null")
    private String password;

    @NotNull(message = "email cannot be null")
    @UniqueEmail(message = "this email is used")
    private String email;
}
