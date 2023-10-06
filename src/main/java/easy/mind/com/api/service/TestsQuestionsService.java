package easy.mind.com.api.service;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.UserDTO;
import easy.mind.com.api.entity.TestsQuestions;

import java.util.List;

public interface TestsQuestionsService {

    TestsQuestions create(TestsQuestions questions);
    TestsQuestions getById(long id);
    void delete(long id);
    List<TestsQuestions> getAll();
}
