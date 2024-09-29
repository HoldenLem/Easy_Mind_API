package easy.mind.com.api.service;

import easy.mind.com.api.entity.TestsAnswers;
import easy.mind.com.api.repository.TestsAnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestsAnswersService {

    private final TestsAnswerRepository repository;

    public TestsAnswers create(TestsAnswers answers, int userId, int testsId) {
        TestsAnswers testsAnswers = repository.save(answers);
        testsAnswers.setUserId(userId);
        testsAnswers.setTestsId(testsId);
        return testsAnswers;
    }

    public List<TestsAnswers> getByUserId(int userId) {
        List<TestsAnswers> testsAnswers = repository.getByUserId(userId);
        if (testsAnswers.isEmpty()) {
            throw new EntityNotFoundException("The user with id " + userId + " has not passed any test yet");
        }
        return testsAnswers;
    }

    public List<TestsAnswers> getAll() {
        return repository.findAll();
    }

}
