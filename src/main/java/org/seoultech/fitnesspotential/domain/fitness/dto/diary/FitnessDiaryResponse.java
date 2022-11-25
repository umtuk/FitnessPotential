package org.seoultech.fitnesspotential.domain.fitness.dto.diary;

import lombok.*;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FitnessDiaryResponse {

    private Long id;
    private Long creatorId;
    private Long fitnessInfoId;

    private String title;

    private Integer sets;
    private List<Integer> reps;
    private List<Integer> breakTimesPerSet;

    private Integer year;
    private Integer month;
    private Integer day;

    private Long createdAt;
    private Long updatedAt;
    private Long deletedAt;

    @Builder
    public FitnessDiaryResponse(Long id, Long creatorId, Long fitnessInfoId, String title, Integer sets, List<Integer> reps, List<Integer> breakTimesPerSet, Integer year, Integer month, Integer day, Long createdAt, Long updatedAt, Long deletedAt) {
        this.id = id;
        this.creatorId = creatorId;
        this.fitnessInfoId = fitnessInfoId;
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.breakTimesPerSet = breakTimesPerSet;
        this.year = year;
        this.month = month;
        this.day = day;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static class FitnessDiaryResponseBuilder {

        private Long id;
        private Long creatorId;
        private Long fitnessInfoId;

        private String title;

        private Integer sets;
        private List<Integer> reps;
        private List<Integer> breakTimesPerSet;

        private Integer year;
        private Integer month;
        private Integer day;

        private Long createdAt;
        private Long updatedAt;
        private Long deletedAt;

        public FitnessDiaryResponseBuilder fitnessDiary(FitnessDiary fitnessDiary) {
            this.id = fitnessDiary.getId();
            this.creatorId = fitnessDiary.getCreatorId();
            this.fitnessInfoId = fitnessDiary.getFitnessInfoId();

            this.title = fitnessDiary.getTitle();

            this.sets = fitnessDiary.getSets();
            this.reps = split(fitnessDiary.getReps());
            this.breakTimesPerSet = split(fitnessDiary.getBreakTimesPerSet());

            this.year = fitnessDiary.getYear();
            this.month = fitnessDiary.getMonth();
            this.day = fitnessDiary.getDay();

            this.createdAt = fitnessDiary.getCreatedAt();
            this.updatedAt = fitnessDiary.getUpdatedAt();
            this.deletedAt = fitnessDiary.getDeletedAt();
            return this;
        }

        private List<Integer> split(String str) {
            List<String> strList = new ArrayList<>(Arrays.asList(str.split(FitnessDiary.FitnessDiaryBuilder.DELIM)));
            return strList.stream().map(Integer::parseInt).collect(Collectors.toList());
        }
    }

}
