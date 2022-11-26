package org.seoultech.fitnesspotential.domain.fitness.dto.routine;

import lombok.*;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitResponse;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FitnessRoutineResponse {

    private List<FitnessUnitResponse> units;
    private Long id;
    private String title;
    private Long creatorId;
    private Long createdAt;
    private Long updatedAt;
    private Long deletedAt;

    @Builder
    public FitnessRoutineResponse(List<FitnessUnitResponse> units, Long id, String title, Long creatorId, Long createdAt, Long updatedAt, Long deletedAt) {
        this.units = units;
        this.id = id;
        this.title = title;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static class FitnessRoutineResponseBuilder {

        private List<FitnessUnitResponse> units;
        private Long id;
        private String title;
        private Long creatorId;
        private Long createdAt;
        private Long updatedAt;
        private Long deletedAt;

        public FitnessRoutineResponseBuilder fitnessRoutine(FitnessRoutine fitnessRoutine) {
            this.units = fitnessRoutine.getUnits().stream()
                    .map(fitnessUnit -> FitnessUnitResponse.builder().fitnessUnit(fitnessUnit).build())
                    .collect(Collectors.toList());
            this.id = fitnessRoutine.getId();
            this.title = fitnessRoutine.getTitle();
            this.creatorId = fitnessRoutine.getCreatorId();
            this.createdAt = fitnessRoutine.getCreatedAt();
            this.updatedAt = fitnessRoutine.getUpdatedAt();
            this.deletedAt = fitnessRoutine.getDeletedAt();
            return this;
        }
    }
}
