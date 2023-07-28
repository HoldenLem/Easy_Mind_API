package EaseMood.com.api.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "beck_depression")
public class BeckDepressionInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_ar", nullable = false)
    private LocalDateTime createdAt;


    @Column(name = "question_one", nullable = false)
    private int questionOne;

    @Column(name = "question_two", nullable = false)
    private int questionTwo;

    @Column(name = "question_three", nullable = false)
    private int questionThree;

    @Column(name = "question_four", nullable = false)
    private int questionFour;

    @Column(name = "question_five", nullable = false)
    private int questionFive;

    @Column(name = "question_six", nullable = false)
    private int questionSix;

    @Column(name = "question_seven", nullable = false)
    private int questionSeven;

    @Column(name = "question_eight", nullable = false)
    private int questionEight;

    @Column(name = "question_nane", nullable = false)
    private int questionNine;

    @Column(name = "question_ten", nullable = false)
    private int questionTen;

    @Column(name = "question_eleven", nullable = false)
    private int questionEleven;

    @Column(name = "question_twelve", nullable = false)
    private int questionTwelve;

    @Column(name = "question_thirteen", nullable = false)
    private int questionThirteen;

    @Column(name = "question_fourteen", nullable = false)
    private int questionFourteen;

    @Column(name = "question_fifteen", nullable = false)
    private int questionFifteen;

    @Column(name = "question_sixteen")
    private int questionSixteen;

    @Column(name = "question_seventeen", nullable = false)
    private int questionSeventeen;

    @Column(name = "question_eighteen", nullable = false)
    private int questionEighteen;

    @Column(name = "question_nineteen", nullable = false)
    private int questionNineteen;

    @Column(name = "question_twenty", nullable = false)
    private int questionTwenty;

    @Column(name = "question_twenty_one", nullable = false)
    private int questionTwentyOne;

    @Column(name = "user_id", nullable = false)
    private int userId;

}
