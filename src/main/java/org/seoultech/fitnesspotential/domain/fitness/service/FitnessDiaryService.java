package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiaryDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiarySummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FitnessDiaryService {

    FitnessDiaryResponse getFitnessDiary(Long id);
    Page<FitnessDiarySummaryResponse> getFitnessDiaries(Pageable pageable);
    FitnessDiaryResponse postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest);
    FitnessDiaryResponse putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest);
    FitnessDiaryDeleteResponse deleteFitnessDiary(Long id);
}