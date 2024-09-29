package easy.mind.com.api.facade;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.DTO.conversion.TestsAnswerToDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestsAnswerFacade {

    private static TestsAnswersService service;

    public TestsAnswersDTO create (TestsAnswersDTO testsAnswersDTO, int userId, int questionId) {
        TestsAnswersDTO result = TestsAnswerToDTO.convert(
                service.create(TestsAnswerToDTO.convert(testsAnswersDTO), userId, questionId));
        return result;
    }

    public List<TestsAnswersDTO> getByUserId (int userId) {
        return service.getByUserId(userId)
                .stream()
                .map(TestsAnswerToDTO::convert)
                .toList();
    }
}
