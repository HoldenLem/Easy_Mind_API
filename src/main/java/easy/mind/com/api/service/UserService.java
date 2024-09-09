package easy.mind.com.api.service;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.DTO.mapper.UserMapper;
import easy.mind.com.api.entity.User;
import easy.mind.com.api.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional
    public UserDTO create(UserDTO userDTO) {
        User user = mapper.userDTOtoUser(userDTO);
        User createdUser = repository.save(user);
        return mapper.userToUserDTO(createdUser);
    }

    @Transactional
    public UserDTO update(UserDTO userDTO) {
        return create(userDTO);
    }

    public UserDTO readById(long id) {
        return repository.findById(id)
                .map(mapper::userToUserDTO)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));

    }

    @Transactional
    public void delete(long id) {
        UserDTO userDTO = readById(id);
        repository.delete(mapper.userDTOtoUser(userDTO));
    }

    public List<UserDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    public void throwIfNotExist(long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }
}
