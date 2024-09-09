package easy.mind.com.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    @NotBlank(message = "cannot be null")
    private String name;

    @NotBlank(message = "cannot be null")
    private String language;

    @NotEmpty(message = "cannot be null or empty")
    private List<QuestionDTO> questions;

    @Builder
    public record QuestionDTO(int order,String description, Map<Integer, String> answers) {
    }
}
