package easy.mind.com.api.DTO.conversion;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.Entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDtoToUserConverter {

    public static User convert(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }
}
