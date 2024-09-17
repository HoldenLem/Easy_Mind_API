package easy.mind.com.api.DTO.conversion;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.entity.TestsAnswers;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestsAnswerToDTO {

    public static TestsAnswers convert(TestsAnswersDTO testsAnswersDTO) {
        return TestsAnswers.builder()
                .id(testsAnswersDTO.getId())
                .createdAt(testsAnswersDTO.getCreatedAt())
                .questionsId(testsAnswersDTO.getQuestionsId())
                .userId(testsAnswersDTO.getUserId())
                .answer(TestsAnswerToDTO.convert(testsAnswersDTO.getAnswer()))
                .build();
    }


    public static TestsAnswersDTO convert(TestsAnswers testsAnswers) {
        return TestsAnswersDTO.builder()
                .id(testsAnswers.getId())
                .createdAt(testsAnswers.getCreatedAt())
                .userId(testsAnswers.getUserId())
                .questionsId(testsAnswers.getQuestionsId())
                .answer(TestsAnswerToDTO.convertToDTO(testsAnswers.getAnswer()))
                .build();
    }

    public static List<TestsAnswers.Answers> convert(List<TestsAnswersDTO.AnswersDTO> source) {
        return source.stream()
                .map(x -> TestsAnswers.Answers.builder()
                        .answers(x.answers())
                        .build())
                .toList();
    }

    public static List<TestsAnswersDTO.AnswersDTO> convertToDTO(List<TestsAnswers.Answers> source) {
        return source.stream()
                .map(x -> TestsAnswersDTO.AnswersDTO.builder()
                        .answers(x.answers())
                        .build())
                .toList();
    }

}
