package EaseMood.com.api.Srvice;

import EaseMood.com.api.DTO.UserDTO;
import EaseMood.com.api.Entity.User;

import java.util.List;

public interface UserService {

    User create(UserDTO user);
    User readById(long id);
    User update(UserDTO userDTO);
    void delete(long id);
    List<User> getAll();
}
