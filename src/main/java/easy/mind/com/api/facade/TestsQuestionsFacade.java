package easy.mind.com.api.facade;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.service.TestsQuestionsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestsQuestionsFacade {

    private final TestsQuestionsService service;
    private final ModelMapper modelMapper;

    public TestsQuestionsDTO create(TestsQuestionsDTO testsQuestionsDTO){
        return modelMapper.map(
                service.create(modelMapper.map(testsQuestionsDTO, TestsQuestions.class)),
                TestsQuestionsDTO.class);
    }

    public TestsQuestionsDTO getById(long id){
        return modelMapper.map(service.getById(id), TestsQuestionsDTO.class);
    }
    public void delete(long id){
         service.delete(id);
    }

    public List<TestsQuestionsDTO> getAll(){
        return service.getAll()
                .stream()
                .map(testsQuestions -> modelMapper.map(testsQuestions, TestsQuestionsDTO.class))
                .toList();
    }
}
