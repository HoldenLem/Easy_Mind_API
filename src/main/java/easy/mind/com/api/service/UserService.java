package easy.mind.com.api.service;

import easy.mind.com.api.DTO.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO create(UserDTO user);
    UserDTO update(UserDTO userDTO);
    UserDTO readById(long id);
    void delete(long id);
    List<UserDTO> getAll();
    void throwIfNotExist(long id);
}
