package easy.mind.com.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestsQuestionsDTO {

    private int id;

    @NotBlank(message = "cannot be null")
    private String name;

    @NotBlank(message = "cannot be null")
    private String language;

    @NotNull(message = "cannot be null")
    private List<Question> questions;

    public record Question(int order, Map<Integer, String> answers) {
    }
}
