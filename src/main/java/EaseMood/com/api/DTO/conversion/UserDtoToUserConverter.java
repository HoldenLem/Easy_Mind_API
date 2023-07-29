package EaseMood.com.api.DTO.conversion;

import EaseMood.com.api.DTO.UserDTO;
import EaseMood.com.api.Entity.User;
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
