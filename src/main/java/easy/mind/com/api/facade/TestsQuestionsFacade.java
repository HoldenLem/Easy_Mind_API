package easy.mind.com.api.facade;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.conversion.TestQuestionsToDto;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.service.TestsQuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestsQuestionsFacade {

    private final TestsQuestionsService service;

    public TestsQuestionsDTO create(TestsQuestionsDTO testsQuestionsDTO){
        TestsQuestionsDTO result =  TestQuestionsToDto.convert(service.create(TestQuestionsToDto.convert(testsQuestionsDTO)));
        return result;
    }

    public TestsQuestionsDTO getById(long id){
        return TestQuestionsToDto.convert(service.getById(id));
    }
    public void delete(long id){
         service.delete(id);
    }

    public List<TestsQuestionsDTO> getAll(){
        return service.getAll()
                .stream()
                .map(TestQuestionsToDto::convert)
                .toList();
    }
}
