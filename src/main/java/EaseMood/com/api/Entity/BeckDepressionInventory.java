package EaseMood.com.api.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.Parent;

import java.time.LocalDateTime;

@Entity
@Table(name = "beck_depression")
public class BeckDepressionInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_ar", nullable = false)
    private LocalDateTime createdAt;


    @Column(name="question_one", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionOne;

    @Column(name="question_two",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionTwo;

    @Column(name="question_three",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionThree;

    @Column(name="question_four",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionFour;

    @Column(name="question_five",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionFive;

    @Column(name="question_six",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionSix;

    @Column(name="question_seven",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionSeven;

    @Column(name="question_eight",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionEight;

    @Column(name="question_nane",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionNine;

    @Column(name="question_ten",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionTen;

    @Column(name="question_eleven",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionEleven;

    @Column(name="question_twelve",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionTwelve;

    @Column(name="question_thirteen",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionThirteen;

    @Column(name="question_fourteen",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionFourteen;

    @Column(name="question_fifteen",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionFifteen;

    @Column(name="question_sixteen")
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionSixteen;

    @Column(name="question_seventeen",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionSeventeen;

    @Column(name="question_eighteen",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionEighteen;

    @Column(name="question_nineteen",nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 5,message = "The value cannot be higher than 5")
    private int questionNineteen;

    @Column(name="question_twenty", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionTwenty;

    @Column(name="question_twenty_one", nullable = false)
    @Min(value = 0, message = "The value cannot be lower than 0")
    @Max(value = 3,message = "The value cannot be higher than 3")
    private int questionTwentyOne;



    public BeckDepressionInventory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public int getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(int questionOne) {
        this.questionOne = questionOne;
    }

    public int getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(int questionTwo) {
        this.questionTwo = questionTwo;
    }

    public int getQuestionThree() {
        return questionThree;
    }

    public void setQuestionThree(int questionThree) {
        this.questionThree = questionThree;
    }

    public int getQuestionFour() {
        return questionFour;
    }

    public void setQuestionFour(int questionFour) {
        this.questionFour = questionFour;
    }

    public int getQuestionFive() {
        return questionFive;
    }

    public void setQuestionFive(int questionFive) {
        this.questionFive = questionFive;
    }

    public int getQuestionSix() {
        return questionSix;
    }

    public void setQuestionSix(int questionSix) {
        this.questionSix = questionSix;
    }

    public int getQuestionSeven() {
        return questionSeven;
    }

    public void setQuestionSeven(int questionSeven) {
        this.questionSeven = questionSeven;
    }

    public int getQuestionEight() {
        return questionEight;
    }

    public void setQuestionEight(int questionEight) {
        this.questionEight = questionEight;
    }

    public int getQuestionNine() {
        return questionNine;
    }

    public void setQuestionNine(int questionNine) {
        this.questionNine = questionNine;
    }

    public int getQuestionTen() {
        return questionTen;
    }

    public void setQuestionTen(int questionTen) {
        this.questionTen = questionTen;
    }

    public int getQuestionEleven() {
        return questionEleven;
    }

    public void setQuestionEleven(int questionEleven) {
        this.questionEleven = questionEleven;
    }

    public int getQuestionTwelve() {
        return questionTwelve;
    }

    public void setQuestionTwelve(int questionTwelve) {
        this.questionTwelve = questionTwelve;
    }

    public int getQuestionThirteen() {
        return questionThirteen;
    }

    public void setQuestionThirteen(int questionThirteen) {
        this.questionThirteen = questionThirteen;
    }

    public int getQuestionFourteen() {
        return questionFourteen;
    }

    public void setQuestionFourteen(int questionFourteen) {
        this.questionFourteen = questionFourteen;
    }

    public int getQuestionFifteen() {
        return questionFifteen;
    }

    public void setQuestionFifteen(int questionFifteen) {
        this.questionFifteen = questionFifteen;
    }

    public int getQuestionSixteen() {
        return questionSixteen;
    }

    public void setQuestionSixteen(int questionSixteen) {
        this.questionSixteen = questionSixteen;
    }

    public int getQuestionSeventeen() {
        return questionSeventeen;
    }

    public void setQuestionSeventeen(int questionSeventeen) {
        this.questionSeventeen = questionSeventeen;
    }

    public int getQuestionEighteen() {
        return questionEighteen;
    }

    public void setQuestionEighteen(int questionEighteen) {
        this.questionEighteen = questionEighteen;
    }

    public int getQuestionNineteen() {
        return questionNineteen;
    }

    public void setQuestionNineteen(int questionNineteen) {
        this.questionNineteen = questionNineteen;
    }

    public int getQuestionTwenty() {
        return questionTwenty;
    }

    public void setQuestionTwenty(int questionTwenty) {
        this.questionTwenty = questionTwenty;
    }

    public int getQuestionTwentyOne() {
        return questionTwentyOne;
    }

    public void setQuestionTwentyOne(int questionTwentyOne) {
        this.questionTwentyOne = questionTwentyOne;
    }

    @Override
    public String toString() {
        return "BeckDepressionInventory{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", questionOne=" + questionOne +
                ", questionTwo=" + questionTwo +
                ", questionThree=" + questionThree +
                ", questionFour=" + questionFour +
                ", questionFive=" + questionFive +
                ", questionSix=" + questionSix +
                ", questionSeven=" + questionSeven +
                ", questionEight=" + questionEight +
                ", questionNine=" + questionNine +
                ", questionTen=" + questionTen +
                ", questionEleven=" + questionEleven +
                ", questionTwelve=" + questionTwelve +
                ", questionThirteen=" + questionThirteen +
                ", questionFourteen=" + questionFourteen +
                ", questionFifteen=" + questionFifteen +
                ", questionSixteen=" + questionSixteen +
                ", questionSeventeen=" + questionSeventeen +
                ", questionEighteen=" + questionEighteen +
                ", questionNineteen=" + questionNineteen +
                ", questionTwenty=" + questionTwenty +
                ", questionTwentyOne=" + questionTwentyOne +
                '}';
    }
}
