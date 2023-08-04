package easy.mind.com.api.Srvice.Impl;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.DTO.conversion.UserDtoToUser;
import easy.mind.com.api.Entity.User;
import easy.mind.com.api.Repository.UserRepository;
import easy.mind.com.api.Srvice.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    @Transactional
    public UserDTO create(UserDTO userDTO) {
        User user = UserDtoToUser.convertToUser(userDTO);
        User createdUser = repository.save(user);
        return UserDtoToUser.convertToUserDTO(createdUser);
    }

    @Override
    public UserDTO readById(long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        return UserDtoToUser.convertToUserDTO(user);
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO userDTO) {
        User user = UserDtoToUser.convertToUser(userDTO);
        User createdUser = repository.save(user);
        return UserDtoToUser.convertToUserDTO(createdUser);
    }

    @Override
    @Transactional
    public void delete(long id) {
        UserDTO userDTO = readById(id);
        if (userDTO != null) repository.delete(UserDtoToUser.convertToUser(userDTO));
        else {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(UserDtoToUser::convertToUserDTO)
                .collect(Collectors.toList());
    }
}
