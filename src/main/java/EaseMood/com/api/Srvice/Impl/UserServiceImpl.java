package EaseMood.com.api.Srvice.Impl;

import EaseMood.com.api.DTO.UserDTO;
import EaseMood.com.api.DTO.conversion.UserDtoToUserConverter;
import EaseMood.com.api.Entity.User;
import EaseMood.com.api.Repository.UserRepository;
import EaseMood.com.api.Srvice.UserService;
import EaseMood.com.api.exception.DuplicateFieldException;
import EaseMood.com.api.exception.NullEntityException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

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
