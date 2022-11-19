package org.seoultech.fitnesspotential.domain.fitness.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="fitness_routine")
public class FitnessRoutine {

    @OneToMany(mappedBy = "fitnessRoutine", fetch = FetchType.LAZY)
    @Column(name="units")
    private List<FitnessUnit> units;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(nullable = false, name="creator_id")
    private Long creatorId;

    @Column(nullable = false, name="created_at")
    private Long createdAt;
    @Column(name="updated_at")
    private Long updatedAt;
    @Column(name="deleted_at")
    private Long deletedAt;

    @Builder
    public FitnessRoutine(List<FitnessUnit> units, Long id, String title, Long creatorId, Long createdAt, Long updatedAt, Long deletedAt) {
        this.units = units;
        this.id = id;
        this.title = title;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static class FitnessRoutineBuilder{

        private List<FitnessUnit> units;

        private Long id;

        private String title;

        private Long creatorId;

        private Long createdAt;

        private Long updatedAt;

        private Long deletedAt;

        public FitnessRoutineBuilder fitnessRoutine(FitnessRoutine fitnessRoutine) {
            this.units = fitnessRoutine.units;
            this.id = fitnessRoutine.id;
            this.title = fitnessRoutine.title;
            this.creatorId = fitnessRoutine.creatorId;
            this.createdAt = fitnessRoutine.createdAt;
            this.updatedAt = fitnessRoutine.updatedAt;
            this.deletedAt = fitnessRoutine.deletedAt;
            return this;
        }

        public FitnessRoutineBuilder fitnessRoutinePostRequest(FitnessRoutinePostRequest fitnessRoutinePostRequest){
            this.title = fitnessRoutinePostRequest.getTitle();
            this.createdAt = System.currentTimeMillis();
            return this;
        }

        public FitnessRoutineBuilder fitnessRoutinePutRequest(FitnessRoutinePutRequest fitnessRoutinePutRequest){
            this.title = fitnessRoutinePutRequest.getTitle() == null? this.title : fitnessRoutinePutRequest.getTitle();
            this.updatedAt = System.currentTimeMillis();
            return this;
        }
    }
}
