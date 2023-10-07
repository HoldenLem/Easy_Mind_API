package easy.mind.com.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private List<QuestionDTO> questions;


    @Builder
    public record QuestionDTO(int order,String description, Map<Integer, String> answers) {

    }
}
