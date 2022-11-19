package org.seoultech.fitnesspotential.domain.fitness.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPutRequest;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "Fitness_unit")
public class FitnessUnit {

    @ManyToOne
    @JoinColumn(name = "fitness_routine_id")
    @JsonBackReference
    private FitnessRoutine fitnessRoutine;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="fitness_info_id")
    private Long fitnessInfoId;

    @Column(nullable = false, length = 32, name="title")
    private String title;

    @Column(nullable = false, name="sets")
    private Integer sets;
    @Column(nullable = false, length = 128, name="reps")
    private String reps;
    @Column(nullable = false, length = 128, name="break_times_per_set")
    private String breakTimesPerSet;

    @Builder
    public FitnessUnit(FitnessRoutine fitnessRoutine, Long id, Long fitnessInfoId, String title, Integer sets, String reps, String breakTimesPerSet) {
        this.fitnessRoutine = fitnessRoutine;
        this.id = id;
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
    }

    public static class FitnessUnitBuilder{

        private FitnessRoutine fitnessRoutine;

        private Long id;

        private Long fitnessInfoId;

        private String title;

        private Integer sets;

        private String reps;

        private String breakTimesPerSet;

        public FitnessUnitBuilder fitnessUnit(FitnessUnit fitnessUnit){
            this.fitnessRoutine = FitnessRoutine.builder().id(fitnessUnit.getFitnessRoutine().getId()).build();
            this.id = fitnessUnit.id;
            this.fitnessInfoId = fitnessUnit.fitnessInfoId;
            this.title = fitnessUnit.title;
            this.sets = fitnessUnit.sets;
            this.reps = fitnessUnit.reps;
            this.breakTimesPerSet = fitnessUnit.breakTimesPerSet;
            return this;
        }

        public FitnessUnitBuilder fitnessUnitPostRequest(FitnessUnitPostRequest fitnessUnitPostRequest){
            this.fitnessRoutine = FitnessRoutine.builder().id(fitnessUnitPostRequest.getFitnessRoutineId()).build();
            this.fitnessInfoId = fitnessUnitPostRequest.getFitnessInfoId();
            this.title = fitnessUnitPostRequest.getTitle();
            this.sets = fitnessUnitPostRequest.getSets();
            this.reps = fitnessUnitPostRequest.getReps();
            this.breakTimesPerSet = fitnessUnitPostRequest.getBreakTimesPerSet();
            return this;
        }

        public FitnessUnitBuilder fitnessUnitPutRequest(FitnessUnitPutRequest fitnessUnitPutRequest){
            this.fitnessInfoId = fitnessUnitPutRequest.getFitnessInfoId() == null ? this.fitnessInfoId : fitnessUnitPutRequest.getFitnessInfoId();
            this.title = fitnessUnitPutRequest.getTitle() == null ? this.title : fitnessUnitPutRequest.getTitle();
            this.sets = fitnessUnitPutRequest.getSets() == null ? this.sets : fitnessUnitPutRequest.getSets();
            this.reps = fitnessUnitPutRequest.getReps() == null ? this.reps : fitnessUnitPutRequest.getReps();
            this.breakTimesPerSet = fitnessUnitPutRequest.getBreakTimesPerSet();
            return this;
        }
    }
}
