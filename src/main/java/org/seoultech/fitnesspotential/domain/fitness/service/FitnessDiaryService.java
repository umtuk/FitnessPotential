package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FitnessDiaryService {

    FitnessDiaryResponse getFitnessDiary(Long id);
    Iterable<FitnessDiaryResponse> getFitnessDiaries(Integer year, Integer month, Integer day, Long creatorId);
    FitnessDiaryResponse postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest, Long creatorId);
    FitnessDiaryResponse putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest, Long id);
    void deleteFitnessDiary(Long id);
}