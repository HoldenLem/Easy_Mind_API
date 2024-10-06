package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.entity.TestsAnswers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestsAnswersMapper {
    TestsAnswersDTO testsAnswersToTestsAnswersDTO(TestsAnswers testsAnswers);
    TestsAnswers testsAnswersDTOtoTestsAnswers(TestsAnswersDTO testsAnswersDTO);
}
