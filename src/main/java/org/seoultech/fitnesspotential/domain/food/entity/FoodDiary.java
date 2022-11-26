package org.seoultech.fitnesspotential.domain.food.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPutRequest;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FoodDiary {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, name="creator_id")
    private Long creatorId;

    @Column(nullable = false, length = 128, name="content")
    private String content;
    @Column(name="intake")
    private Integer intake;
    @Column(name="intake_unit")
    private String intakeUnit;
    @Column(nullable = false, name="kcal")
    private Double kcal;
    @Column(nullable = false, name="carbs")
    private Double carbs;
    @Column(nullable = false, name="protein")
    private Double protein;
    @Column(nullable = false, name="fat")
    private Double fat;
    @Column(nullable = false, name="year")
    private Integer year;
    @Column(nullable = false, name="month")
    private Integer month;
    @Column(nullable = false, name="day")
    private Integer day;
    @Column(nullable = false, name = "intake_time")
    private Long intakeTime;
    @Column(nullable = false, name="created_at")
    private Long createdAt;
    @Column(name="updated_at")
    private Long updatedAt;
    @Column(name="deleted_at")
    private Long deletedAt;

    @Builder
    public FoodDiary(Long id, Long creatorId, String content, Integer intake, String intakeUnit, Double kcal, Double carbs, Double protein, Double fat, Integer year, Integer month, Integer day, Long intakeTime, Long createdAt, Long updatedAt, Long deletedAt) {
        this.id = id;
        this.creatorId = creatorId;
        this.content = content;
        this.intake = intake;
        this.intakeUnit = intakeUnit;
        this.kcal = kcal;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.year = year;
        this.month = month;
        this.day = day;
        this.intakeTime = intakeTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }


    public static class FoodDiaryBuilder {

        private Long id;
        private Long creatorId;
        private String content;
        private Integer intake;
        private String intakeUnit;
        private Double kcal;
        private Double carbs;
        private Double protein;
        private Double fat;
        private Integer year;
        private Integer month;
        private Integer day;
        private Long intakeTime;
        private Long createdAt;
        private Long updatedAt;
        private Long deletedAt;

        public FoodDiaryBuilder foodDiary(FoodDiary foodDiary){
            this.id = foodDiary.id;
            this.creatorId = foodDiary.creatorId;
            this.content = foodDiary.content;
            this.intake = foodDiary.intake;
            this.intakeUnit = foodDiary.intakeUnit;
            this.kcal = foodDiary.kcal;
            this.carbs = foodDiary.carbs;
            this.protein = foodDiary.protein;
            this.fat = foodDiary.fat;
            this.year = foodDiary.year;
            this.month = foodDiary.month;
            this.day = foodDiary.day;
            this.intakeTime = foodDiary.intakeTime;
            this.createdAt = foodDiary.createdAt;
            this.updatedAt = foodDiary.updatedAt;
            this.deletedAt = foodDiary.deletedAt;
            return this;
        }

        public FoodDiaryBuilder foodDiaryPostRequest(FoodDiaryPostRequest foodDiaryPostRequest){
            this.content = foodDiaryPostRequest.getContent();
            this.intake = foodDiaryPostRequest.getIntake();
            this.intakeUnit = foodDiaryPostRequest.getIntakeUnit();
            this.kcal = foodDiaryPostRequest.getKcal();
            this.carbs = foodDiaryPostRequest.getCarbs();
            this.protein = foodDiaryPostRequest.getProtein();
            this.fat = foodDiaryPostRequest.getFat();
            this.year = foodDiaryPostRequest.getYear();
            this.month = foodDiaryPostRequest.getMonth();
            this.day = foodDiaryPostRequest.getDay();
            this.intakeTime = foodDiaryPostRequest.getIntakeTime();
            this.createdAt = System.currentTimeMillis();
            return this;
        }

        public FoodDiaryBuilder foodDiaryPutRequest(FoodDiaryPutRequest foodDiaryPutRequest){
            this.content = foodDiaryPutRequest.getContent() == null ? this.content : foodDiaryPutRequest.getContent();
            this.intake = foodDiaryPutRequest.getIntake() == null ? this.intake : foodDiaryPutRequest.getIntake();
            this.intakeUnit = foodDiaryPutRequest.getIntakeUnit() == null ? this.intakeUnit : foodDiaryPutRequest.getIntakeUnit();
            this.kcal = foodDiaryPutRequest.getKcal() == null ? this.kcal : foodDiaryPutRequest.getKcal();
            this.carbs = foodDiaryPutRequest.getCarbs() == null ? this.carbs : foodDiaryPutRequest.getCarbs();
            this.protein = foodDiaryPutRequest.getProtein() == null ? this.protein : foodDiaryPutRequest.getProtein();
            this.fat = foodDiaryPutRequest.getFat() == null ? this.fat : foodDiaryPutRequest.getFat();
            this.year = foodDiaryPutRequest.getYear() == null ? this.year : foodDiaryPutRequest.getYear();
            this.month = foodDiaryPutRequest.getMonth() == null ? this.month : foodDiaryPutRequest.getMonth();
            this.day = foodDiaryPutRequest.getDay() == null ? this.day : foodDiaryPutRequest.getDay();
            this.intakeTime = foodDiaryPutRequest.getIntakeTime() == null ? this.intakeTime : foodDiaryPutRequest.getIntakeTime();
            this.updatedAt = System.currentTimeMillis();
            return this;
        }
    }
}
