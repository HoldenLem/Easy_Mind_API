package easy.mind.com.api.сontroller;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.facade.TestsQuestionsFacade;
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
    private final TestsQuestionsFacade testsQuestionsFacade;

    @GetMapping("/{id}")
    public ResponseEntity<TestsQuestionsDTO> read(@PathVariable int id,  @PathVariable int userId) {
        return ResponseEntity.ok()
                .body(testsQuestionsFacade.getById(id));
    }

    @GetMapping
    private ResponseEntity<List<TestsQuestionsDTO>> getAllQuestions() {
        return ResponseEntity.ok().body(testsQuestionsFacade.getAll());
    }
}
