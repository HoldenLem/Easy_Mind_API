package EaseMood.com.api.Controller;

import EaseMood.com.api.DTO.UserDTO;
import EaseMood.com.api.Entity.User;
import EaseMood.com.api.Srvice.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.readById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> update(@Valid @RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.update(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

}
