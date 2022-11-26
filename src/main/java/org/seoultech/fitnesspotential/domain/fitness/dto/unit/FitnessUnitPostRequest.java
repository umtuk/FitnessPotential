package org.seoultech.fitnesspotential.domain.fitness.dto.unit;

import lombok.*;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.util.List;

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
    @Positive
    private Integer sets;

    @NotNull
    @Size(min = 1, max = 10)
    private List<@Positive Integer> reps;

    @NotNull
    @Size(min = 1, max = 10)
    private List<@Positive Integer> breakTimesPerSet;

    @Builder
    public FitnessUnitPostRequest(Long fitnessRoutineId, Long fitnessInfoId, String title, Integer sets, List<Integer> reps, List<Integer> breakTimesPerSet) {
        this.fitnessRoutineId = fitnessRoutineId;
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
    }
}
