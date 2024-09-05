package easy.mind.com.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import easy.mind.com.api.DTO.annotation.UniqueEmail;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @NotBlank(message = "firstname cannot be blank")
    private String firstName;

    @NotBlank(message = "lastname cannot be blank")
    private String lastName;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "password cannot be blank")
    @UniqueEmail(message = "this email is used")
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "this email is invalid")
    private String email;
}
