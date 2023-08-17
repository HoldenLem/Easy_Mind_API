package easy.mind.com.api.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "beck_depression")
public class BeckDepressionInventory extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "sadness", nullable = false)
    private int sadness;

    @Column(name = "concerns", nullable = false)
    private int concerns;

    @Column(name = "selfEsteem", nullable = false)
    private int selfEsteem;

    @Column(name = "pleasure", nullable = false)
    private int pleasure;

    @Column(name = "fault", nullable = false)
    private int fault;

    @Column(name = "punishment", nullable = false)
    private int punishment;

    @Column(name = "selfLove", nullable = false)
    private int selfLove;

    @Column(name = "selfCriticism", nullable = false)
    private int selfCriticism;

    @Column(name = "suicide", nullable = false)
    private int suicide;

    @Column(name = "question_ten", nullable = false)
    private int weep;

    @Column(name = "question_eleven", nullable = false)
    private int irritability;

    @Column(name = "interestInPeople", nullable = false)
    private int interestInPeople;

    @Column(name = "determination", nullable = false)
    private int determination;

    @Column(name = "appearance", nullable = false)
    private int appearance;

    @Column(name = "workAbility", nullable = false)
    private int workAbility;

    @Column(name = "sleep")
    private int sleep;

    @Column(name = "fatigue", nullable = false)
    private int fatigue;

    @Column(name = "appetite", nullable = false)
    private int appetite;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "heals", nullable = false)
    private int heals;

    @Column(name = "libido", nullable = false)
    private int libido;


}
