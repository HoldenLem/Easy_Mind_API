package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.entity.TestsQuestions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestsQuestionsMapperTests {
    @Autowired
    private TestsQuestionsMapper mapper;

    @Test
    public void shouldConvertTestsQuestionsToTestsQuestionsDTO() {
        TestsQuestions testsQuestions = TestsQuestions.builder()
                .id(100)
                .language("English")
                .name("Beck Depression Inventory")
                .questions(List.of(
                        TestsQuestions.Question.builder()
                                .order(1)
                                .description("some description")
                                .answers(Map.of(
                                        1, "yes",
                                        2, "no"
                                ))
                                .build(),
                        TestsQuestions.Question.builder()
                                .order(2)
                                .description("another description")
                                .answers(Map.of(
                                        1, "first option",
                                        2, "second option",
                                        3, "third option"
                                ))
                                .build()
                ))
                .build();
        TestsQuestionsDTO actualTestsQuestionsDTO = mapper.testsQuestionsToTestsQuestionsDTO(testsQuestions);
        TestsQuestionsDTO expectedTestQuestionDTO =  TestsQuestionsDTO.builder()
                .id(100)
                .language("English")
                .name("Beck Depression Inventory")
                .questions(List.of(
                        TestsQuestionsDTO.QuestionDTO.builder()
                                .order(1)
                                .description("Some description")
                                .answers(Map.of(
                                        1, "yes",
                                        2, "no"
                                ))
                                .build(),
                        TestsQuestionsDTO.QuestionDTO.builder()
                                .order(2)
                                .description("another description")
                                .answers(Map.of(
                                        1, "first option",
                                        2, "second option",
                                        3, "third option"
                                ))
                                .build()
                ))
                .build();
        assertThat(actualTestsQuestionsDTO).isEqualTo(expectedTestQuestionDTO);
    }

    @Test
    public void shouldConvertTestsQuestionsDTOtoTestsQuestions() {
        TestsQuestionsDTO testsQuestionsDTO = TestsQuestionsDTO.builder()
                .id(0)
                .language("German")
                .name("some name")
                .questions(List.of(
                        TestsQuestionsDTO.QuestionDTO.builder()
                                .order(1)
                                .description("some description")
                                .answers(Map.of(
                                        1, "some answer"
                                ))
                                .build()
                ))
                .build();
        TestsQuestions actualTestsQuestions = mapper.testsQuestionsDTOtoTestQuestions(testsQuestionsDTO);
        TestsQuestions expectedTestsQuestions = TestsQuestions.builder()
                .id(0)
                .language("German")
                .name("some name")
                .questions(List.of(
                        TestsQuestions.Question.builder()
                                .order(1)
                                .description("some description")
                                .answers(Map.of(
                                        1, "some answer"
                                ))
                                .build()
                ))
                .build();
        assertThat(actualTestsQuestions).isEqualTo(expectedTestsQuestions);
    }
}
