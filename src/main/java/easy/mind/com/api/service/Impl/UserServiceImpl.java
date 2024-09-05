package easy.mind.com.api.service.Impl;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.User;
import easy.mind.com.api.repository.UserRepository;
import easy.mind.com.api.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDTO create(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User createdUser = repository.save(user);
        return modelMapper.map(createdUser, UserDTO.class);
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO userDTO) {
        return create(userDTO);
    }


    @Override
    public UserDTO readById(long id) {
        return repository.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));

    }

    @Override
    @Transactional
    public void delete(long id) {
        UserDTO userDTO = readById(id);
        repository.delete(modelMapper.map(userDTO, User.class));
    }

    @Override
    public List<UserDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void throwIfNotExist(long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }
}
