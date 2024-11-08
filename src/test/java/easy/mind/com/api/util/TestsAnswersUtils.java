package easy.mind.com.api.util;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.entity.TestsAnswers;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TestsAnswersUtils {
    private final static long DEFAULT_TEST_ID = 1;
    private static final long DEFAULT_ID = 1;
    private static final List<TestsAnswersDTO.AnswersDTO> ANSWERS_DTOS = List.of(
            TestsAnswersDTO.AnswersDTO.builder()
                    .answers(Map.of(3, 4, 5, 8))
                    .build(),
            TestsAnswersDTO.AnswersDTO.builder()
                    .answers(Map.of(7, 8))
                    .build()
    );
    private static final List<TestsAnswers.Answers> ANSWERS = List.of(
            TestsAnswers.Answers.builder()
                    .answers(Map.of(3, 4, 5, 8))
                    .build(),
            TestsAnswers.Answers.builder()
                    .answers(Map.of(7, 8))
                    .build()
    );

    public static TestsAnswersDTO dto() {
        return TestsAnswersDTO.builder()
                .id(DEFAULT_ID)
                .testsId(DEFAULT_TEST_ID)
                .answers(ANSWERS_DTOS)
                .build();
    }

    public  static TestsAnswers entity(){
        return TestsAnswers.builder()
                .testsId(DEFAULT_ID)
                .id(DEFAULT_ID)
                .answers(ANSWERS)
                .build();

    }

}
