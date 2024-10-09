package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.entity.TestsAnswers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TestsAnswersMapperTests {
    @Autowired
    TestsAnswersMapper mapper;


    @Test
    void dtoToEntity() {
        TestsAnswersDTO testsAnswersDTO = TestsAnswersDTO.builder()
                .createdAt(null)
                .modifiedAt(null)
                .testsId(11)
                .userId(12)
                .answers(List.of(
                        TestsAnswersDTO.AnswersDTO.builder()
                                .answers(Map.of(
                                        3, 4,
                                        5, 8))
                                .build(),
                        TestsAnswersDTO.AnswersDTO.builder()
                                .answers(Map.of(
                                        7, 8
                                ))
                                .build()

                ))
                .build();
        TestsAnswers actualTestsAnswers = mapper.of(testsAnswersDTO);
        TestsAnswers expectedTestsAnswers = TestsAnswers.builder()
                .createdAt(null)
                .modifiedAt(null)
                .testsId(11)
                .userId(12)
                .answers(List.of(
                        TestsAnswers.Answers.builder()
                                .answers(Map.of(
                                        3, 4,
                                        5, 8))
                                .build(),
                        TestsAnswers.Answers.builder()
                                .answers(Map.of(
                                        7, 8
                                ))
                                .build()

                ))
                .build();
        assertThat(actualTestsAnswers).isEqualTo(expectedTestsAnswers);
    }

    void entityToDto(Instant modifiedAt) {
        TestsAnswers testsAnswers = TestsAnswers.builder()
                .id(2)
                .createdAt(Instant.parse("2007-12-03T10:15:30.00Z"))
                .modifiedAt(modifiedAt)
                .testsId(1)
                .userId(5)
                .answers(List.of(
                        TestsAnswers.Answers.builder()
                                .answers(Map.of(3, 4))
                                .build()
                ))
                .build();
        TestsAnswersDTO actualTestsAnswersDTO = mapper.of(testsAnswers);
        TestsAnswersDTO expectedTestsAnswersDTO = TestsAnswersDTO.builder()
                .createdAt(Instant.parse("2007-12-03T10:15:30.00Z"))
                .modifiedAt(modifiedAt)
                .testsId(1)
                .userId(5)
                .answers(List.of(
                        TestsAnswersDTO.AnswersDTO.builder()
                                .answers(Map.of(3, 4))
                                .build()
                ))
                .build();
        assertThat(actualTestsAnswersDTO).isEqualTo(expectedTestsAnswersDTO);
    }

    @Test
    void entityToDto() {
        entityToDto(Instant.parse("2008-11-07T3:16:20.00Z"));
    }

    @Test
    void nullableField() {
        entityToDto(null);
    }
}
