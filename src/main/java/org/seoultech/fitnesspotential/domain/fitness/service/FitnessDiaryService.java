package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;

public interface FitnessDiaryService {

    FitnessDiary getFitnessDiary(Long id);
    Iterable<FitnessDiary> getFitnessDiaries(Integer year, Integer month, Integer day, Long creatorId);
    FitnessDiary postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest, Long creatorId);
    FitnessDiary putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest, Long id);
    void deleteFitnessDiary(Long id);
}