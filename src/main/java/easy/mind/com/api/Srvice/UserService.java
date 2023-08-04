package easy.mind.com.api.Srvice;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.Entity.User;

import java.util.List;

public interface UserService {

    UserDTO create(UserDTO user);
    UserDTO readById(long id);
    UserDTO update(UserDTO userDTO);
    void delete(long id);
    List<UserDTO> getAll();
}
