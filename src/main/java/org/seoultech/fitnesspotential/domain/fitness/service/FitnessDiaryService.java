package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryInfo;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;

public interface FitnessDiaryService {

    FitnessDiary getFitnessDiary(Long id);
    Iterable<FitnessDiary> getFitnessDiaries(Integer year, Integer month, Integer day, Long creatorId);
    Iterable<FitnessDiary> getFitnessDiaries(Long fitnessInfoId, Long creatorId);
    Iterable<FitnessDiaryInfo> getFitnessDiaryInfos(Long creatorId);
    FitnessDiary postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest, Long creatorId);
    FitnessDiary putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest, Long id);
    void deleteFitnessDiary(Long id);
}