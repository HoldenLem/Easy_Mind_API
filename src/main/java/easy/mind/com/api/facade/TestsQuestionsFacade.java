package easy.mind.com.api.facade;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.mapper.TestQuestionsMapper;
import easy.mind.com.api.service.TestsQuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestsQuestionsFacade {

    private final TestsQuestionsService service;
    private final TestQuestionsMapper mapper;

    public TestsQuestionsDTO create(TestsQuestionsDTO testsQuestionsDTO){
        return mapper.testsQuestionsToTestsQuestionsDTO(
                service.create(mapper.testsQuestionsDTOtoTestQuestions(testsQuestionsDTO))
                );
    }

    public TestsQuestionsDTO getById(long id){
        return mapper.testsQuestionsToTestsQuestionsDTO(service.getById(id));
    }
    public void delete(long id){
         service.delete(id);
    }

    public List<TestsQuestionsDTO> getAll(){
        return service.getAll()
                .stream()
                .map(mapper::testsQuestionsToTestsQuestionsDTO)
                .toList();
    }
}
