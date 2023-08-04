package easy.mind.com.api.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class BeckDepressionInventoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private LocalDateTime createdAt;

    private int questionOne;


    private int questionTwo;

    @Column(name = "question_three", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionThree;

    @Column(name = "question_four", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionFour;

    @Column(name = "question_five", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionFive;

    @Column(name = "question_six", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionSix;

    @Column(name = "question_seven", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionSeven;

    @Column(name = "question_eight", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionEight;

    @Column(name = "question_nane", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionNine;

    @Column(name = "question_ten", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionTen;

    @Column(name = "question_eleven", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionEleven;

    @Column(name = "question_twelve", nullable = false)

    private int questionTwelve;

    @Column(name = "question_thirteen", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionThirteen;

    @Column(name = "question_fourteen", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionFourteen;

    @Column(name = "question_fifteen", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionFifteen;

    @Column(name = "question_sixteen")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionSixteen;

    @Column(name = "question_seventeen", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionSeventeen;

    @Column(name = "question_eighteen", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionEighteen;

    @Column(name = "question_nineteen", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 5, message = "The value cannot be higher than 5")
    private int questionNineteen;

    @Column(name = "question_twenty", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionTwenty;

    @Column(name = "question_twenty_one", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3, message = "The value cannot be higher than 3")
    private int questionTwentyOne;

    @Column(name = "user_id", nullable = false)
    private int userId;
}