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


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional
    public UserDTO create(UserDTO userDTO) {
        User user = mapper.of(userDTO);
        User createdUser = repository.save(user);
        return mapper.of(createdUser);
    }

    @Transactional
    public UserDTO update(UserDTO userDTO) {
        return create(userDTO);
    }

    public UserDTO readBy(long id) {
        return repository.findById(id)
                .map(mapper::of)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));

    }

    @Transactional
    public void delete(long id) {
        UserDTO userDTO = readBy(id);
        repository.delete(mapper.of(userDTO));
    }

    public List<UserDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::of)
                .toList();
    }

}
