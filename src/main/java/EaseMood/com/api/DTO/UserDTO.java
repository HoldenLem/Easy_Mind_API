package EaseMood.com.api.DTO;

import EaseMood.com.api.DTO.annotation.UniqueEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

    private int id;

    @NotNull(message = "firstname cannot be null")
    @NotBlank(message = "firstname cannot be blank")
    private String firstName;

    @NotNull(message = "lastname cannot be null")
    @NotBlank(message = "lastname cannot be blank")
    private String lastName;

    @NotNull(message = "password cannot be null")
    @NotBlank(message = "password cannot be blank")
    private String password;

    @NotNull(message = "email cannot be null")
    @NotBlank(message = "email cannot be blank")
    @UniqueEmail(message = "this email is used")
    private String email;
}