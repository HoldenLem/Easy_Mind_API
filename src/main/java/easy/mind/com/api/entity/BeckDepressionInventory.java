package easy.mind.com.api.entity;

import jakarta.persistence.*;

import lombok.*;


import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "beck_depression")
public class BeckDepressionInventory extends BaseEntity {

    private int id = super.getId();

    private Instant createdAt = super.getCreatedAt();

    @Column(name = "question_one", nullable = false)
    private int sadness;

    @Column(name = "question_two", nullable = false)
    private int concerns;

    @Column(name = "question_three", nullable = false)
    private int selfEsteem;

    @Column(name = "question_four", nullable = false)
    private int pleasure;

    @Column(name = "question_five", nullable = false)
    private int fault;

    @Column(name = "question_six", nullable = false)
    private int punishment;

    @Column(name = "question_seven", nullable = false)
    private int selfLove;

    @Column(name = "question_eight", nullable = false)
    private int selfCriticism;

    @Column(name = "question_nine", nullable = false)
    private int suicide;

    @Column(name = "question_ten", nullable = false)
    private int weep;

    @Column(name = "question_eleven", nullable = false)
    private int irritability;

    @Column(name = "question_twelve", nullable = false)
    private int interestInPeople;

    @Column(name = "question_thirteen", nullable = false)
    private int determination;

    @Column(name = "question_fourteen", nullable = false)
    private int appearance;

    @Column(name = "question_fifteen", nullable = false)
    private int workAbility;

    @Column(name = "question_sixteen")
    private int sleep;

    @Column(name = "question_seventeen", nullable = false)
    private int fatigue;

    @Column(name = "question_eighteen", nullable = false)
    private int appetite;

    @Column(name = "question_nineteen", nullable = false)
    private int weight;

    @Column(name = "question_twenty", nullable = false)
    private int heals;

    @Column(name = "question_twenty_one", nullable = false)
    private int libido;

    @Column(name = "user_id", nullable = false)
    private int userId;

}
