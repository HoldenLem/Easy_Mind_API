package easy.mind.com.api.service.Impl;

import easy.mind.com.api.entity.TestsAnswers;
import easy.mind.com.api.repository.TestsAnswerRepository;
import easy.mind.com.api.service.TestsAnswersService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestsAnswersServiceImpl implements TestsAnswersService {

    private final TestsAnswerRepository repository;

    @Override
    public TestsAnswers create(TestsAnswers answers, int userId, int questionId) {
        TestsAnswers testsAnswers = repository.save(answers);
        testsAnswers.setUserId(userId);
        testsAnswers.setQuestionsId(questionId);
        return testsAnswers;
    }

    @Override
    public List<TestsAnswers> getByUserId(int userId) {
        List<TestsAnswers> testsAnswers = repository.getByUserId(userId);
        if (testsAnswers.isEmpty()) {
            throw new EntityNotFoundException("The user with id " + userId + " has not passed any test yet");
        }
        return testsAnswers;
    }


    @Override
    public List<TestsAnswers> getAll() {
        return repository.findAll();
    }

}
