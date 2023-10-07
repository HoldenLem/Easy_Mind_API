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

    @Override
    @Transactional
    public TestsQuestions create(TestsQuestions questions) {
        return repository.save(questions);
    }

    @Override
    public TestsQuestions getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Questions with id " + id + " not found"));
    }

    @Override
    public void delete(long id) {
        repository.delete(getById(id));
    }

    @Override
    public List<TestsQuestions> getAll() {
        return repository.findAll();
    }
}
