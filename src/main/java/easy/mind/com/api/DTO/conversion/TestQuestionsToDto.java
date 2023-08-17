package easy.mind.com.api.DTO.conversion;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import easy.mind.com.api.DTO.TestsQuestionsDTO;
import easy.mind.com.api.entity.TestsQuestions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestQuestionsToDto {

    private static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public static TestsQuestions convert(TestsQuestionsDTO testsQuestionsDTO) {
        return TestsQuestions.builder()
                .id(testsQuestionsDTO.getId())
                .language(testsQuestionsDTO.getLanguage())
                .name(testsQuestionsDTO.getName())
                .questions(mapper.writeValueAsString(testsQuestionsDTO.getQuestions()))
                .build();
    }

    @SneakyThrows
    public static TestsQuestionsDTO convert(TestsQuestions testsQuestions) {
        return TestsQuestionsDTO.builder()
                .id(testsQuestions.getId())
                .language(testsQuestions.getLanguage())
                .name(testsQuestions.getName())
                .questions(mapper.readValue(testsQuestions.getQuestions(), new TypeReference<>() {
                }))
                .build();
    }
}
