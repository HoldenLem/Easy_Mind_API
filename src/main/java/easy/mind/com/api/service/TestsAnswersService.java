package easy.mind.com.api.service;

import easy.mind.com.api.entity.TestsAnswers;
import easy.mind.com.api.entity.TestsQuestions;

import java.util.List;

public interface TestsAnswersService {
    TestsAnswers create( TestsAnswers answers, int userId, int questionId);

    List<TestsAnswers> getByUserId(int userId);

    List<TestsAnswers> getAll();

}
