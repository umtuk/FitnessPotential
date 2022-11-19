package org.seoultech.fitnesspotential.domain.fitness.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FitnessUnit {

    @ManyToOne
    @JoinColumn(name = "fitness_routine_id")
    private FitnessRoutine fitnessRoutine;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long fitnessInfoId;

    @Column(nullable = false, length = 32)
    private String title;

    @Column(nullable = false)
    private Integer sets;
    @Column(nullable = false, length = 128)
    private String reps;
    @Column(nullable = false, length = 128)
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
}
