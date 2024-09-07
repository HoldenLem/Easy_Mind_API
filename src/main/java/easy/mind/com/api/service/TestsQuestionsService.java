package easy.mind.com.api.service;

import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.repository.TestsQuestionsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestsQuestionsService {

    private final TestsQuestionsRepository repository;

    @Transactional
    public TestsQuestions create(TestsQuestions questions) {
        return repository.save(questions);
    }

    public TestsQuestions getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Questions with id " + id + " not found"));
    }

    public void delete(long id) {
        repository.delete(getById(id));
    }

    public List<TestsQuestions> getAll() {
        return repository.findAll();
    }
}
