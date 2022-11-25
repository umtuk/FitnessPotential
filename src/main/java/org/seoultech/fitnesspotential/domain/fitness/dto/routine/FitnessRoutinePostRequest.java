package org.seoultech.fitnesspotential.domain.fitness.dto.routine;

import lombok.*;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FitnessRoutinePostRequest {

    @NotNull
    @Size(min = 1, max = 20)
    private String title;

    @Builder
    public FitnessRoutinePostRequest(String title){
        this.title = title;
    }
}
