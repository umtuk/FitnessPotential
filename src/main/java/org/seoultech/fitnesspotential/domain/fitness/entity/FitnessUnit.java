package org.seoultech.fitnesspotential.domain.fitness.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPutRequest;

import javax.persistence.*;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "fitness_unit_reps", joinColumns = @JoinColumn(name = "fitness_unit_id"))
    @Column(length = 32)
    private List<Integer> reps;
    @ElementCollection
    @CollectionTable(name = "fitness_unit_break_time_per_set", joinColumns = @JoinColumn(name = "fitness_unit_id"))
    @Column(length = 32)
    private List<Integer> breakTimesPerSet;

    @ElementCollection
    @CollectionTable(name = "fitness_unit_weights", joinColumns = @JoinColumn(name = "fitness_unit_id"))
    @Column(length = 32)
    private List<Integer> weights;

    @Builder
    public FitnessUnit(FitnessRoutine fitnessRoutine, Long id, Long fitnessInfoId, String title, Integer sets, List<Integer> reps, List<Integer> breakTimesPerSet, List<Integer> weights) {
        this.fitnessRoutine = fitnessRoutine;
        this.id = id;
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
        this.weights = weights;
    }

    public static class FitnessUnitBuilder {

        private FitnessRoutine fitnessRoutine;
        private Long id;
        private Long fitnessInfoId;
        private String title;
        private Integer sets;
        private List<Integer> reps;
        private List<Integer> breakTimesPerSet;
        private List<Integer> weights;

        public FitnessUnitBuilder fitnessUnit(FitnessUnit fitnessUnit){
            this.fitnessRoutine = fitnessUnit.fitnessRoutine;
            this.id = fitnessUnit.id;
            this.fitnessInfoId = fitnessUnit.fitnessInfoId;
            this.title = fitnessUnit.title;
            this.sets = fitnessUnit.sets;
            this.reps = fitnessUnit.reps;
            this.breakTimesPerSet = fitnessUnit.breakTimesPerSet;
            this.weights = fitnessUnit.weights;
            return this;
        }

        public FitnessUnitBuilder fitnessUnitPostRequest(FitnessUnitPostRequest fitnessUnitPostRequest){
            this.fitnessRoutine = FitnessRoutine.builder().id(fitnessUnitPostRequest.getFitnessRoutineId()).build();
            this.fitnessInfoId = fitnessUnitPostRequest.getFitnessInfoId();
            this.title = fitnessUnitPostRequest.getTitle();
            this.sets = fitnessUnitPostRequest.getSets();
            this.reps = fitnessUnitPostRequest.getReps();
            this.breakTimesPerSet = fitnessUnitPostRequest.getBreakTimesPerSet();
            this.weights = fitnessUnitPostRequest.getWeights();
            return this;
        }

        public FitnessUnitBuilder fitnessUnitPutRequest(FitnessUnitPutRequest fitnessUnitPutRequest){
            this.fitnessInfoId = fitnessUnitPutRequest.getFitnessInfoId() == null ? this.fitnessInfoId : fitnessUnitPutRequest.getFitnessInfoId();
            this.title = fitnessUnitPutRequest.getTitle() == null ? this.title : fitnessUnitPutRequest.getTitle();
            this.sets = fitnessUnitPutRequest.getSets() == null ? this.sets : fitnessUnitPutRequest.getSets();
            this.reps = fitnessUnitPutRequest.getReps() == null ? this.reps : fitnessUnitPutRequest.getReps();
            this.breakTimesPerSet = fitnessUnitPutRequest.getBreakTimesPerSet() == null ? this.breakTimesPerSet : fitnessUnitPutRequest.getBreakTimesPerSet();
            this.weights = fitnessUnitPutRequest.getWeights() == null ? this.weights : fitnessUnitPutRequest.getWeights();
            return this;
        }
    }
}
