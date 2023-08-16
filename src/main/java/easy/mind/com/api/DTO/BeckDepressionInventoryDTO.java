package easy.mind.com.api.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;


@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BeckDepressionInventoryDTO {


    private Instant createdAt;

    private int id;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int sadness;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int concerns;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int selfEsteem;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int pleasure;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int fault;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int punishment;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int selfLove;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int selfCriticism;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int suicide;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int weep;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int irritability;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int interestInPeople;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int determination;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int appearance;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int workAbility;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int sleep;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int fatigue;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int appetite;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 5, message = "The value cannot be higher than 5")
    private int weight;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int heals;

    @NotNull(message = "cannot be null")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int libido;

    @NotNull(message = "cannot be null")
    @Column(name = "user_id", nullable = false)
    private int userId;
}
