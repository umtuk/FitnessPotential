package org.seoultech.fitnesspotential.domain.food.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FoodDiaryPutRequest {

    @NotNull
    @Size(min=5, max=1024)
    private String content;

    @NotNull
    @Positive
    private Integer intake;

    @NotNull
    @Size(min=2, max=10)
    private String intakeUnit;

    @NotNull
    @Positive
    private Double kcal;

    @NotNull
    @Positive
    private Double carbs;

    @NotNull
    @Positive
    private Double protein;

    @NotNull
    @Positive
    private Double fat;

    @NotNull
    @PositiveOrZero
    private Integer year;

    @NotNull
    @Min(1)
    @Max(12)
    private Integer month;

    @NotNull
    @Min(1)
    @Max(31)
    private Integer day;

    @NotNull
    @Positive
    private Long intakeTime;
}
