package easy.mind.com.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "tests_answers")
public class TestsAnswers extends BaseEntity {

    @Column(name = "tests_id")
    private int questionsId;

    @Column(name = "user_id")
    private int userId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<TestsAnswers.Answers> answer;

    @Builder
    public record Answers( Map<Integer, Integer> answers) {
    }

}
