package easy.mind.com.api.facade;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.DTO.mapper.TestsAnswersMapper;
import easy.mind.com.api.service.TestsAnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestsAnswerFacade {

    private final TestsAnswersService service;
    private final TestsAnswersMapper mapper;

    public TestsAnswersDTO create (TestsAnswersDTO testsAnswersDTO, int userId, int questionId) {
        TestsAnswersDTO result = mapper.testsAnswersToTestsAnswersDTO(
                service.create(mapper.testsAnswersDTOtoTestsAnswers(testsAnswersDTO), userId, questionId));
        return result;
    }

    public List<TestsAnswersDTO> getByUserId (int userId) {
        return service.getByUserId(userId)
                .stream()
                .map(mapper::testsAnswersToTestsAnswersDTO)
                .toList();
    }
}
