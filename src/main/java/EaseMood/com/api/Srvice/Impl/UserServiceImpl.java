package EaseMood.com.api.Srvice.Impl;

import EaseMood.com.api.DTO.UserDTO;
import EaseMood.com.api.DTO.conversion.UserDtoToUserConverter;
import EaseMood.com.api.Entity.User;
import EaseMood.com.api.Repository.UserRepository;
import EaseMood.com.api.Srvice.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    @Transactional
    public User create(UserDTO userDTO) {
        User user = UserDtoToUserConverter.convert(userDTO);
        return repository.save(user);
    }

    @Override
    public User readById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    @Override
    @Transactional
    public User update(UserDTO userDTO) {
        User user = UserDtoToUserConverter.convert(userDTO);
        return repository.save(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        User user = readById(id);
        if (user != null) repository.delete(user);
        else {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
