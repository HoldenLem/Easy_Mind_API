package easy.mind.com.api.facade;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.mapper.TestsQuestionsMapper;
import easy.mind.com.api.service.TestsQuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestsQuestionsFacade {

    private final TestsQuestionsService service;
    private final TestsQuestionsMapper mapper;

    public TestsQuestionsDTO create(TestsQuestionsDTO testsQuestionsDTO){
        return mapper.of(
                service.create(mapper.of(testsQuestionsDTO))
                );
    }

    public TestsQuestionsDTO getBy(long id){
        return mapper.of(service.getById(id));
    }
    public void delete(long id){
         service.delete(id);
    }

    public List<TestsQuestionsDTO> getAll(){
        return service.getAll()
                .stream()
                .map(mapper::of)
                .toList();
    }
}
