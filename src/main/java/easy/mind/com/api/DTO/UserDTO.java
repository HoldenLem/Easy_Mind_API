package easy.mind.com.api.DTO;

import easy.mind.com.api.DTO.annotation.UniqueEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class UserDTO {

    private int id;

    @NotBlank(message = "firstname cannot be blank")
    private String firstName;

    @NotBlank(message = "lastname cannot be blank")
    private String lastName;

    @NotBlank(message = "password cannot be blank")
    private String password;

    @NotBlank(message = "password cannot be blank")
    @UniqueEmail(message = "this email is used")
    private String email;
}
