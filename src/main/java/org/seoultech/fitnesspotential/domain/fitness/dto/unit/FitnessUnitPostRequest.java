package org.seoultech.fitnesspotential.domain.fitness.dto.unit;

import lombok.*;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FitnessUnitPostRequest {

    @NotNull
    private Long fitnessRoutineId;

    @NotNull
    private Long fitnessInfoId;

    @NotNull
    @Size(min = 5, max = 64)
    private String title;

    @NotNull
    @Min(value = 0, message = "The value must be positive")
    private Integer sets;

    @NotNull
    @Size(min = 1)
    private String reps;

    @NotNull
    private String breakTimesPerSet;

    @Builder
    public FitnessUnitPostRequest(Long fitnessRoutineId, Long fitnessInfoId, String title, Integer sets, String reps, String breakTimesPerSet){
        this.fitnessRoutineId = fitnessRoutineId;
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
    }
}
