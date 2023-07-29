package EaseMood.com.api.DTO.conversion;

import EaseMood.com.api.DTO.UserDTO;
import EaseMood.com.api.Entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDtoToUserConverter {

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }
}
