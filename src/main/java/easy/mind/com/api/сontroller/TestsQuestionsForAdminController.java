package easy.mind.com.api.сontroller;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.facade.TestsQuestionsFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class TestsQuestionsForAdminController {
    private final TestsQuestionsFacade testsQuestionsFacade;

    @PostMapping
    public ResponseEntity<TestsQuestionsDTO> createQuestions(@Valid @RequestBody TestsQuestionsDTO testsQuestionsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(testsQuestionsFacade.create(testsQuestionsDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TestsQuestionsDTO> deleteQuestion(@PathVariable int id) {
        testsQuestionsFacade.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    private ResponseEntity<List<TestsQuestionsDTO>> getAllQuestions() {
        return ResponseEntity.ok().body(testsQuestionsFacade.getAll());
    }

}
