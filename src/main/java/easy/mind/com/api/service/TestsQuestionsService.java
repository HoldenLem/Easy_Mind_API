package easy.mind.com.api.service;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.UserDTO;

import java.util.List;

public interface TestsQuestionsService {

    TestsQuestionsDTO create(TestsQuestionsDTO questionsDTO);
    TestsQuestionsDTO readById(long id,int userId );
    void delete(long id, int userId);
    List<TestsQuestionsDTO> getAll();
}
