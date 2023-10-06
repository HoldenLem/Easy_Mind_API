package easy.mind.com.api.DTO.conversion;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.DTO.TestsQuestionsDTO.QuestionDTO;
import easy.mind.com.api.entity.TestsQuestions;
import easy.mind.com.api.entity.TestsQuestions.Question;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestQuestionsToDto {


    public static TestsQuestions convert(TestsQuestionsDTO testsQuestionsDTO) {
        return TestsQuestions.builder()
                .id(testsQuestionsDTO.getId())
                .language(testsQuestionsDTO.getLanguage())
                .name(testsQuestionsDTO.getName())
                .questions(TestQuestionsToDto.convert(testsQuestionsDTO.getQuestions()))
                .build();
    }


    public static TestsQuestionsDTO convert(TestsQuestions testsQuestions) {
        return TestsQuestionsDTO.builder()
                .id(testsQuestions.getId())
                .language(testsQuestions.getLanguage())
                .name(testsQuestions.getName())
                .questions(TestQuestionsToDto.convertToDTO(testsQuestions.getQuestions()))
                .build();
    }

    public static List<Question> convert(List<QuestionDTO> source) {
        return source.stream()
                .map(x -> Question.builder()
                        .order(x.order())
                        .description(x.description())
                        .answers(x.answers())
                        .build())
                .toList();
    }

    public static List<QuestionDTO> convertToDTO(List<Question> source) {
        return source.stream()
                .map(x -> QuestionDTO.builder()
                        .order(x.order())
                        .description(x.description())
                        .answers(x.answers())
                        .build())
                .toList();
    }

}
