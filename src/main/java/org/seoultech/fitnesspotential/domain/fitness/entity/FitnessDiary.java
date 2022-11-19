package org.seoultech.fitnesspotential.domain.fitness.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FitnessDiary {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long creatorId;
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

    @Column(nullable = false)
    private Long createdAt;
    @Column
    private Long updatedAt;
    @Column
    private Long deletedAt;

    @Builder
    public FitnessDiary(Long id, Long creatorId, Long fitnessInfoId, String title, Integer sets, String reps, String breakTimesPerSet, Long createdAt, Long updatedAt, Long deletedAt) {
        this.id = id;
        this.creatorId = creatorId;
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
