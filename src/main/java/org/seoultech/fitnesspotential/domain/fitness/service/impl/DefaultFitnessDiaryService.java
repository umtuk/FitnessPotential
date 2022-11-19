package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiaryDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiarySummaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessDiaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFitnessDiaryService implements FitnessDiaryService {
    @Override
    public FitnessDiaryResponse getFitnessDiary(Long id) {
        return null;
    }

    @Override
    public Page<FitnessDiarySummaryResponse> getFitnessDiaries(Pageable pageable) {
        return null;
    }

    @Override
    public FitnessDiaryResponse postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest) {
        return null;
    }

    @Override
    public FitnessDiaryResponse putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest) {
        return null;
    }

    @Override
    public FitnessDiaryDeleteResponse deleteFitnessDiary(Long id) {
        return null;
    }
}
