package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.entity.TestsQuestions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestsQuestionsMapper {
    TestsQuestionsDTO of(TestsQuestions testsQuestions);
    TestsQuestions of(TestsQuestionsDTO testsQuestionsDTO);
}
