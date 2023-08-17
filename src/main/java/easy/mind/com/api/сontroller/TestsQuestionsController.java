package easy.mind.com.api.сontroller;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.service.TestsQuestionsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/questions")
@RequiredArgsConstructor
public class TestsQuestionsController {

    private final TestsQuestionsService testsQuestionsService;

    @PostMapping
    public ResponseEntity<TestsQuestionsDTO> createQuestions(@Valid @RequestBody TestsQuestionsDTO testsQuestionsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(testsQuestionsService.create(testsQuestionsDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestsQuestionsDTO> read(@PathVariable int id,  @PathVariable int userId) {
        return ResponseEntity.ok()
                .body(testsQuestionsService.readById(id,userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TestsQuestions> deleteUser(@PathVariable int id, @PathVariable int userId) {
        testsQuestionsService.delete(id,userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    private ResponseEntity<List<TestsQuestionsDTO>> getAllUsers() {
        return ResponseEntity.ok().body(testsQuestionsService.getAll());
    }
}
