package org.seoultech.fitnesspotential.domain.food.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FoodDiary {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long creatorId;

    @Column(nullable = false, length = 128)
    private String content;

    @Column
    private Integer intake;
    @Column
    private String intakeUnit;

    @Column(nullable = false)
    private Double kcal;
    @Column(nullable = false)
    private Double carbs;
    @Column(nullable = false)
    private Double protein;
    @Column(nullable = false)
    private Double fat;

    @Column(nullable = false)
    private Long createAt;
    @Column
    private Long updatedAt;
    @Column
    private Long deletedAt;

    @Builder
    public FoodDiary(Long id, Long creatorId, String content, Integer intake, String intakeUnit, Double kcal, Double carbs, Double protein, Double fat, Long createAt, Long updatedAt, Long deletedAt) {
        this.id = id;
        this.creatorId = creatorId;
        this.content = content;
        this.intake = intake;
        this.intakeUnit = intakeUnit;
        this.kcal = kcal;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
