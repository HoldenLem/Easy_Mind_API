package easy.mind.com.api.сontroller;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.facade.TestsQuestionsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}/questions")
@RequiredArgsConstructor
public class TestsQuestionsController {
    private final TestsQuestionsFacade testsQuestionsFacade;

    @GetMapping("/{id}")
    public ResponseEntity<TestsQuestionsDTO> read(@PathVariable int id,  @PathVariable int userId) {
        return ResponseEntity.ok()
                .body(testsQuestionsFacade.getBy(id));
    }

}
