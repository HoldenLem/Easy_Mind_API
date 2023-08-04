package easy.mind.com.api.service.Impl;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.DTO.conversion.UserDtoToUser;
import easy.mind.com.api.entity.User;
import easy.mind.com.api.repository.UserRepository;
import easy.mind.com.api.service.UserService;
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
    public void delete(long id) {
        UserDTO userDTO = readById(id);
        repository.delete(UserDtoToUser.convertToUser(userDTO));
    }

    @Override
    public List<UserDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(UserDtoToUser::convertToUserDTO)
                .collect(Collectors.toList());
    }
}
