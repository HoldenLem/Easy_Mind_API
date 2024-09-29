package easy.mind.com.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestsAnswersDTO {

    private int id;

    private Instant createdAt;

    private Instant modifiedAt;

    @NotNull(message = "cannot be null")
    private int questionsId;

    @NotNull(message = "cannot be null")
    private int userId;

    @NotEmpty
    private List<TestsAnswersDTO.AnswersDTO> answer;

    @Builder
    public record AnswersDTO(Map<Integer, Integer> answers) {
    }

}
