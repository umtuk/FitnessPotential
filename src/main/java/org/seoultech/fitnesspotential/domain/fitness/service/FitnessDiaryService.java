package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FitnessDiaryService {

    FitnessDiary getFitnessDiary(Long id);
    Page<FitnessDiary> getFitnessDiaries(Pageable pageable);
    FitnessDiary postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest, Long creatorId);
    FitnessDiary putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest, Long id);
    void deleteFitnessDiary(Long id);
}