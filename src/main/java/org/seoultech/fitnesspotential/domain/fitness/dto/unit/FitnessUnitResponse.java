package org.seoultech.fitnesspotential.domain.fitness.dto.unit;

import lombok.*;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FitnessUnitResponse {

    private Long id;
    private Long fitnessInfoId;
    private String title;
    private Integer sets;
    private List<Integer> reps;
    private List<Integer> breakTimesPerSet;

    @Builder
    public FitnessUnitResponse(Long id, Long fitnessInfoId, String title, Integer sets, List<Integer> reps, List<Integer> breakTimesPerSet) {
        this.id = id;
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
    }

    public static class  FitnessUnitResponseBuilder {

        private Long id;
        private Long fitnessInfoId;
        private String title;
        private Integer sets;
        private List<Integer> reps;
        private List<Integer> breakTimesPerSet;

        public FitnessUnitResponseBuilder fitnessUnit(FitnessUnit fitnessUnit) {
            this.id = fitnessUnit.getId();
            this.fitnessInfoId = fitnessUnit.getFitnessInfoId();
            this.title = fitnessUnit.getTitle();
            this.sets = fitnessUnit.getSets();
            this.reps = split(fitnessUnit.getReps());
            this.breakTimesPerSet = split(fitnessUnit.getBreakTimesPerSet());
            return this;
        }

        private List<Integer> split(String str) {
            List<String> strList = new ArrayList<>(Arrays.asList(str.split(FitnessUnit.FitnessUnitBuilder.DELIM)));
            return strList.stream().map(Integer::parseInt).collect(Collectors.toList());
        }
    }
}
