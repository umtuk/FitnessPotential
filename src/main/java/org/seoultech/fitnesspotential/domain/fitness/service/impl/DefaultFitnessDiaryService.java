package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryInfo;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.exception.FitnessDiaryErrorMessage;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessDiaryRepository;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessDiaryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DefaultFitnessDiaryService implements FitnessDiaryService {

    private final FitnessDiaryRepository fitnessDiaryRepository;

    @Autowired
    public DefaultFitnessDiaryService(FitnessDiaryRepository fitnessDiaryRepository){
        this.fitnessDiaryRepository = fitnessDiaryRepository;
    }

    @Override
    @Transactional
    public FitnessDiary getFitnessDiary(Long id) {
        return fitnessDiaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessDiaryErrorMessage.FITNESS_DIARY_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public Iterable<FitnessDiary> getFitnessDiaries(Integer year, Integer month, Integer day, Long creatorId) {
        return fitnessDiaryRepository.findByYearAndMonthAndDayAndCreatorId(year, month, day, creatorId);
    }

    @Override
    @Transactional
    public Iterable<FitnessDiary> getFitnessDiaries(Long fitnessInfoId, Long creatorId) {
        return fitnessDiaryRepository.findByFitnessInfoIdAndCreatorId(fitnessInfoId, creatorId);
    }

    @Override
    @Transactional
    public Iterable<FitnessDiaryInfo> getFitnessDiaryInfos(Long creatorId) {
        return fitnessDiaryRepository.findByCreatorId(creatorId);
    }

    @Override
    @Transactional
    public FitnessDiary postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest, Long creatorId) {
        FitnessDiary fitnessDiary = FitnessDiary.builder()
                .creatorId(creatorId)
                .fitnessDiaryPostRequest(fitnessDiaryPostRequest)
                .build();
        return fitnessDiaryRepository.save(fitnessDiary);
    }

    @Override
    @Transactional
    public FitnessDiary putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest, Long id) {
        FitnessDiary fitnessDiary = fitnessDiaryRepository.findById(id).orElseThrow();

        FitnessDiary beforeUpdate = FitnessDiary.builder()
                .fitnessDiary(fitnessDiary)
                .fitnessDiaryPutRequest(fitnessDiaryPutRequest)
                .build();
        return fitnessDiaryRepository.save(beforeUpdate);
    }

    @Override
    @Transactional
    public void deleteFitnessDiary(Long id) {
        if(fitnessDiaryRepository.existsById(id)) {
            fitnessDiaryRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException(FitnessDiaryErrorMessage.FITNESS_DIARY_NOT_FOUND.toString());
        }
    }
}
