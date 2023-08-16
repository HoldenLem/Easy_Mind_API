package easy.mind.com.api.DTO;

import easy.mind.com.api.DTO.annotation.SpectrumValidation;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;


@Data
@Builder
@NoArgsConstructor()
@AllArgsConstructor
public class BeckDepressionInventoryDTO {


    private Instant createdAt;

    private int id;

    @SpectrumValidation
    private int sadness;

    @SpectrumValidation
    private int concerns;

    @SpectrumValidation
    private int selfEsteem;

    @SpectrumValidation
    private int pleasure;

    @SpectrumValidation
    private int fault;

    @SpectrumValidation
    private int punishment;

    @SpectrumValidation
    private int selfLove;

    @SpectrumValidation
    private int selfCriticism;

    @SpectrumValidation
    private int suicide;

    @SpectrumValidation
    private int weep;

    @SpectrumValidation
    private int irritability;

    @SpectrumValidation
    private int interestInPeople;

    @SpectrumValidation
    private int determination;

    @SpectrumValidation
    private int appearance;

    @SpectrumValidation
    private int workAbility;

    @SpectrumValidation
    private int sleep;

    @SpectrumValidation
    private int fatigue;

    @SpectrumValidation
    private int appetite;

    @SpectrumValidation
    private int weight;

    @SpectrumValidation
    private int heals;

    @SpectrumValidation
    private int libido;

    @NotNull(message = "cannot be null")
    private int userId;
}
