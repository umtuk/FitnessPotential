package org.seoultech.fitnesspotential.domain.fitness.dto.unit;

import lombok.*;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FitnessUnitPutRequest {

    @NotNull
    private Long fitnessInfoId;

    @NotNull
    @Size(min = 5, max = 64)
    private String title;

    @NotNull
    @Min(value = 0, message = "The value must be positive")
    private Integer sets;

    @NotNull
    @Size(min = 1, max = 10)
    private List<Integer> reps;

    @NotNull
    @Size(min = 1, max = 10)
    private List<Integer> breakTimesPerSet;

    @Builder
    public FitnessUnitPutRequest(Long fitnessInfoId, String title, Integer sets, List<Integer> reps, List<Integer> breakTimesPerSet) {
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
    }
}
