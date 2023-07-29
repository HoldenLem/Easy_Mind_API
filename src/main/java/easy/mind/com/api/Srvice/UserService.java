package easy.mind.com.api.Srvice;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.Entity.User;

import java.util.List;

public interface UserService {

    User create(UserDTO user);
    User readById(long id);
    User update(UserDTO userDTO);
    void delete(long id);
    List<User> getAll();
}
