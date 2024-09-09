package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOtoUser(UserDTO userDTO);
}
