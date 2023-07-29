package EaseMood.com.api.Controller;

import EaseMood.com.api.DTO.UserDTO;
import EaseMood.com.api.Entity.User;
import EaseMood.com.api.Srvice.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable int id) {
        return ResponseEntity.ok()
                .body(userService.readById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> update(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok()
                .body(userService.update(userDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }

}
