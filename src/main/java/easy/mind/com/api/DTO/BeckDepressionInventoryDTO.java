package easy.mind.com.api.DTO;

import easy.mind.com.api.DTO.annotation.TestAnswerValidation;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeckDepressionInventoryDTO {


    private Instant createdAt;

    private int id;

    @TestAnswerValidation
    private int sadness;

    @TestAnswerValidation
    private int concerns;

    @TestAnswerValidation
    private int selfEsteem;

    @TestAnswerValidation
    private int pleasure;

    @TestAnswerValidation
    private int fault;

    @TestAnswerValidation
    private int punishment;

    @TestAnswerValidation
    private int selfLove;

    @TestAnswerValidation
    private int selfCriticism;

    @TestAnswerValidation
    private int suicide;

    @TestAnswerValidation
    private int weep;

    @TestAnswerValidation
    private int irritability;

    @TestAnswerValidation
    private int interestInPeople;

    @TestAnswerValidation
    private int determination;

    @TestAnswerValidation
    private int appearance;

    @TestAnswerValidation
    private int workAbility;

    @TestAnswerValidation
    private int sleep;

    @TestAnswerValidation
    private int fatigue;

    @TestAnswerValidation
    private int appetite;

    @TestAnswerValidation
    private int weight;

    @TestAnswerValidation
    private int heals;

    @TestAnswerValidation
    private int libido;

    @NotNull(message = "cannot be null")
    private int userId;
}
