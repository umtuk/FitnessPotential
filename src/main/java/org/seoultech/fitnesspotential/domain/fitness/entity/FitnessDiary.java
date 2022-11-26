package org.seoultech.fitnesspotential.domain.fitness.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "fitness_diary")
@Getter
public class FitnessDiary {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(nullable = false, name = "creator_id")
    private Long creatorId;
    @Column(name="fitness_info_id")
    private Long fitnessInfoId;

    @Column(nullable = false, length = 32, name="title")
    private String title;

    @Column(nullable = false, name="sets")
    private Integer sets;
    @ElementCollection
    @CollectionTable(name = "fitness_diary_reps", joinColumns = @JoinColumn(name = "fitness_unit_id"))
    @Column(length = 32)
    private List<Integer> reps;
    @ElementCollection
    @CollectionTable(name = "fitness_diary_break_time_per_set", joinColumns = @JoinColumn(name = "fitness_unit_id"))
    @Column(length = 32)
    private List<Integer> breakTimesPerSet;

    @ElementCollection
    @CollectionTable(name = "fitness_diary_weights", joinColumns = @JoinColumn(name = "fitness_unit_id"))
    @Column(length = 32)
    private List<Integer> weights;

    @Column(nullable = false, name="year")
    private Integer year;

    @Column(nullable = false, name ="month")
    private Integer month;

    @Column(nullable = false, name="day")
    private Integer day;

    @Column(nullable = false, name="created_at")
    private Long createdAt;
    @Column(name="updated_at")
    private Long updatedAt;
    @Column(name="deleted_at")
    private Long deletedAt;

    @Builder
    public FitnessDiary(Long id, Long creatorId, Long fitnessInfoId, String title, Integer sets, List<Integer> reps, List<Integer> breakTimesPerSet, List<Integer> weights, Integer year, Integer month, Integer day, Long createdAt, Long updatedAt, Long deletedAt) {
        this.id = id;
        this.creatorId = creatorId;
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
        this.weights = weights;
        this.year = year;
        this.month = month;
        this.day = day;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static class FitnessDiaryBuilder {

        private Long id;
        private Long creatorId;
        private Long fitnessInfoId;
        private String title;
        private Integer sets;
        private List<Integer> reps;
        private List<Integer> breakTimesPerSet;
        private List<Integer> weights;
        private Integer year;
        private Integer month;
        private Integer day;
        private Long createdAt;
        private Long updatedAt;
        private Long deletedAt;

        public FitnessDiaryBuilder fitnessDiary(FitnessDiary fitnessDiary){
            this.id = fitnessDiary.id;
            this.creatorId = fitnessDiary.creatorId;
            this.fitnessInfoId = fitnessDiary.fitnessInfoId;
            this.title = fitnessDiary.title;
            this.sets = fitnessDiary.sets;
            this.reps = fitnessDiary.reps;
            this.breakTimesPerSet = fitnessDiary.breakTimesPerSet;
            this.year = fitnessDiary.year;
            this.month = fitnessDiary.month;
            this.day = fitnessDiary.day;
            this.createdAt = fitnessDiary.createdAt;
            this.updatedAt = fitnessDiary.updatedAt;
            this.deletedAt = fitnessDiary.deletedAt;
            return this;
        }

        public FitnessDiaryBuilder fitnessDiaryPostRequest(FitnessDiaryPostRequest fitnessDiaryPostRequest){
            this.title = fitnessDiaryPostRequest.getTitle();
            this.sets = fitnessDiaryPostRequest.getSets();
            this.reps = fitnessDiaryPostRequest.getReps();
            this.breakTimesPerSet = fitnessDiaryPostRequest.getBreakTimesPerSet();
            this.weights = fitnessDiaryPostRequest.getWeights();
            this.fitnessInfoId = fitnessDiaryPostRequest.getFitnessInfoId();
            this.year = fitnessDiaryPostRequest.getYear();
            this.month = fitnessDiaryPostRequest.getMonth();
            this.day = fitnessDiaryPostRequest.getDay();
            this.createdAt = System.currentTimeMillis();
            return this;
        }
        public FitnessDiaryBuilder fitnessDiaryPutRequest(FitnessDiaryPutRequest fitnessDiaryPutRequest){
            this.title = fitnessDiaryPutRequest.getTitle() == null ? this.title : fitnessDiaryPutRequest.getTitle();
            this.breakTimesPerSet = fitnessDiaryPutRequest.getBreakTimesPerSet() == null ? this.breakTimesPerSet : fitnessDiaryPutRequest.getBreakTimesPerSet();
            this.reps = fitnessDiaryPutRequest.getReps() == null ? this.reps : fitnessDiaryPutRequest.getReps();
            this.sets = fitnessDiaryPutRequest.getSets() == null ? this.sets : fitnessDiaryPutRequest.getSets();
            this.weights = fitnessDiaryPutRequest.getWeights() == null ? this.weights : fitnessDiaryPutRequest.getWeights();
            this.year = fitnessDiaryPutRequest.getYear() == null ? this.year : fitnessDiaryPutRequest.getYear();
            this.month = fitnessDiaryPutRequest.getMonth() == null ? this.month : fitnessDiaryPutRequest.getMonth();
            this.day = fitnessDiaryPutRequest.getDay() == null ? this.day : fitnessDiaryPutRequest.getDay();
            this.updatedAt = System.currentTimeMillis();
            return this;
        }
    }
}
