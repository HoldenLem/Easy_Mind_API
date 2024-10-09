package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.entity.TestsAnswers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestsAnswersMapper {
    TestsAnswersDTO of(TestsAnswers testsAnswers);
    TestsAnswers of(TestsAnswersDTO testsAnswersDTO);
}
