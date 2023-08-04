package easy.mind.com.api.DTO.conversion;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class UserDtoToUser {

    public static User convertToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }

    public static UserDTO convertToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
