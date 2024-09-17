package easy.mind.com.api.сontroller;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.TestsAnswers;
import easy.mind.com.api.facade.TestsAnswerFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/questions/{questionsId}")
@RequiredArgsConstructor
public class TestsAnswersController {

    private final TestsAnswerFacade testsAnswerFacade;

    @PostMapping
    public ResponseEntity<TestsAnswersDTO> create (
            @Valid @RequestBody TestsAnswersDTO testsAnswers, @PathVariable int userId, @PathVariable int questionId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(testsAnswerFacade.create(testsAnswers, userId, questionId));
    }

    @GetMapping
    public ResponseEntity<List<TestsAnswersDTO>> getByUserId (@PathVariable int userId) {
        return ResponseEntity.ok().body(testsAnswerFacade.getByUserId(userId));
    }
}
