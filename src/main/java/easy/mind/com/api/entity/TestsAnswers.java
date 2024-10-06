package easy.mind.com.api.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
public class TestsAnswers extends BaseEntity {

    @Column(nullable = false)
    private long testsId;

    @Column(nullable = false)
    private long userId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", nullable = false)
    private List<Answers> answers;

    @Builder
    public record Answers( Map<Integer, Integer> answers) {
    }

}
