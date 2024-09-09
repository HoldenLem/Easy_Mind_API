package easy.mind.com.api.entity;

import easy.mind.com.api.DTO.TestsQuestionsDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class TestsQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String language;

    private String name;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Question> questions;

    @Builder
    public record Question(int order,String description, Map<Integer, String> answers) {
    }
}
