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
        User user = UserDtoToUser.convert(userDTO);
        User createdUser = repository.save(user);
        return UserDtoToUser.convert(createdUser);
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO userDTO) {
        return create(userDTO);
    }


    @Override
    public UserDTO readById(long id) {
        return repository.findById(id)
                .map(UserDtoToUser::convert)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));

    }

    @Override
    @Transactional
    public void delete(long id) {
        UserDTO userDTO = readById(id);
        repository.delete(UserDtoToUser.convert(userDTO));
    }

    @Override
    public List<UserDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(UserDtoToUser::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void throwIfNotExist(long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }
}
