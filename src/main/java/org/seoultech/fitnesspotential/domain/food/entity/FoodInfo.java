package org.seoultech.fitnesspotential.domain.food.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FoodInfo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", length = 32)
    private String name;
    @Column(nullable = false, length = 32)
    private String majorCategory;
    @Column(nullable = false, length = 32)
    private String detailedCategory;
    @Column(nullable = false)
    private Integer servingSize;
    @Column(nullable = false, length = 8)
    private String servingSizeUnit;
    @Column(nullable = false)
    private Double kcal;
    @Column(nullable = false)
    private Double carbs;
    @Column(nullable = false)
    private Double protein;
    @Column(nullable = false)
    private Double fat;
    @Column(nullable = false)
    private Long updatedAt;

    @Builder
    public FoodInfo(Long id, String majorCategory, String detailedCategory, Integer servingSize, String servingSizeUnit, Double kcal, Double carbs, Double protein, Double fat, Long updatedAt) {
        this.id = id;
        this.majorCategory = majorCategory;
        this.detailedCategory = detailedCategory;
        this.servingSize = servingSize;
        this.servingSizeUnit = servingSizeUnit;
        this.kcal = kcal;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.updatedAt = updatedAt;
    }

    public static class FoodInfoBuilder{

        private Long id;

        private String name;

        private String majorCategory;

        private String detailedCategory;

        private Integer servingSize;

        private String servingSizeUnit;

        private Double kcal;

        private Double carbs;

        private Double protein;

        private Double fat;

        private Long updatedAt;

        public FoodInfoBuilder foodInfo(FoodInfo foodInfo){
            this.id = foodInfo.id;
            this.name = foodInfo.name;
            this.majorCategory = foodInfo.majorCategory;
            this.detailedCategory = foodInfo.detailedCategory;
            this.servingSize = foodInfo.servingSize;
            this.servingSizeUnit = foodInfo.servingSizeUnit;
            this.kcal = foodInfo.kcal;
            this.carbs = foodInfo.carbs;
            this.protein = foodInfo.protein;
            this.fat = foodInfo.fat;
            this.updatedAt = foodInfo.updatedAt;
            return this;
        }
    }
}
