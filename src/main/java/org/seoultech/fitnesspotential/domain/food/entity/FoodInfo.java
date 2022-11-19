package org.seoultech.fitnesspotential.domain.food.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FoodInfo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 32)
    private String manufacturer;
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
}
