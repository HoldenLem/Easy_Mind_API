package easy.mind.com.api.сontroller;

import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.User;
import easy.mind.com.api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(userDTO));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> read(@PathVariable int userId) {
        return ResponseEntity.ok()
                .body(userService.readById(userId));
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> update(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok()
                .body(userService.update(userDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable int userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    private ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }

}
