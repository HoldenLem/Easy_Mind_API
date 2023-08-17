package easy.mind.com.api.service.Impl;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.conversion.TestQuestionsToDto;
import easy.mind.com.api.DTO.conversion.UserDtoToUser;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.entity.User;
import easy.mind.com.api.exception.RateLimitExceededException;
import easy.mind.com.api.facade.TestsFacade;
import easy.mind.com.api.repository.TestsQuestionsRepository;
import easy.mind.com.api.service.TestsQuestionsService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestsQuestionsServiceImpl implements TestsQuestionsService {

    private final TestsQuestionsRepository repository;

    private final TestsFacade testsFacade;

    @Override
    @Transactional
    public TestsQuestionsDTO create(TestsQuestionsDTO questionsDTO) {
        TestsQuestions createdTestQuestion = repository.save(TestQuestionsToDto.convert(questionsDTO));
        return TestQuestionsToDto.convert(createdTestQuestion);
    }

    @Override
    public TestsQuestionsDTO readById(long id, int userId) {
        if (testsFacade.hasExceededRateLimit(userId)) {
            throw new RateLimitExceededException("You can pass test only once a day");
        }
        TestsQuestions testsQuestions = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Questions with id " + id + " not found"));
        return TestQuestionsToDto.convert(testsQuestions);
    }

    @Override
    public void delete(long id, int userId) {
        TestsQuestionsDTO testsQuestionsDTO = readById(id, userId);
        repository.delete(TestQuestionsToDto.convert(testsQuestionsDTO));
    }

    @Override
    public List<TestsQuestionsDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(TestQuestionsToDto::convert)
                .collect(Collectors.toList());
    }
}
