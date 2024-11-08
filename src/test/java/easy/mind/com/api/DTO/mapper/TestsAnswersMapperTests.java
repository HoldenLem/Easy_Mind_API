package easy.mind.com.api.DTO.mapper;

import easy.mind.com.api.DTO.TestsAnswersDTO;
import easy.mind.com.api.entity.TestsAnswers;
import easy.mind.com.api.util.TestsAnswersUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class TestsAnswersMapperTests {
    @Autowired
    TestsAnswersMapper mapper;

    @Test
    void dtoToEntity() {
        TestsAnswersDTO testsAnswersDTO = TestsAnswersUtils.dto();
        TestsAnswers expected =TestsAnswersUtils.entity();

        TestsAnswers actual = mapper.of(testsAnswersDTO);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual.getTestsId()).isEqualTo(expected.getTestsId());
        assertThat(actual.getUserId()).isEqualTo(expected.getUserId());
    }

    @Test
    void entityToDto() {
        TestsAnswers testsAnswers = TestsAnswersUtils.entity();
        TestsAnswersDTO expected = TestsAnswersUtils.dto();

        TestsAnswersDTO actual = mapper.of(testsAnswers);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual.getTestsId()).isEqualTo(expected.getTestsId());
        assertThat(actual.getUserId()).isEqualTo(expected.getUserId());
    }

    @Test
    void nullDtoToEntity() {
        TestsAnswers actual = mapper.of((TestsAnswersDTO) null);
        assertThat(actual).isNull();
    }

}
