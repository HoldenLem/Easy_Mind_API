package easy.mind.com.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant createdAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant modifiedAt;

    @NotNull(message = "testsId cannot be null")
    private long testsId;

    @NotNull(message = "userId cannot be null")
    private long userId;

    @NotEmpty(message = "answers cannot be null or empty")
    private List<AnswersDTO> answers;

    @Builder
    public record AnswersDTO(@NotEmpty(message = "answers cannot be null or empty") Map<Integer, Integer> answers) {
    }

}
