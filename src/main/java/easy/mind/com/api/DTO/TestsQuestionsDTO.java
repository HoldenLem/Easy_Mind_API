package easy.mind.com.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestsQuestionsDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotBlank(message = "name cannot be null")
    private String name;

    @NotBlank(message = "language cannot be null or blank")
    private String language;

    @NotEmpty(message = "questions cannot be null or empty")
    private List<QuestionDTO> questions;

    @Builder
    public record QuestionDTO(@Positive(message = "order cannot be negative") int order,
                              @NotBlank(message = "descriptions cannot be null or blank") String description,
                              @NotEmpty(message = "answers cannot be null or empty") Map<Integer, String> answers) {
    }
}
