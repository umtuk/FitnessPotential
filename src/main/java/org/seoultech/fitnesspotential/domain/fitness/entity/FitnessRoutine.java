package org.seoultech.fitnesspotential.domain.fitness.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FitnessRoutine {

    @OneToMany(mappedBy = "fitnessRoutine", fetch = FetchType.LAZY)
    private List<FitnessUnit> units;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long creatorId;

    @Column(nullable = false)
    private Long createdAt;
    @Column
    private Long updatedAt;
    @Column
    private Long deletedAt;

    @Builder
    public FitnessRoutine(List<FitnessUnit> units, Long id, Long creatorId, Long createdAt, Long updatedAt, Long deletedAt) {
        this.units = units;
        this.id = id;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
