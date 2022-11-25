package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
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
    public FitnessDiaryResponse getFitnessDiary(Long id) {
        FitnessDiary fitnessDiary = fitnessDiaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessDiaryErrorMessage.FITNESS_DIARY_NOT_FOUND.toString()));
        return FitnessDiaryResponse.builder()
                .fitnessDiary(fitnessDiary)
                .build();
    }

    @Override
    public Iterable<FitnessDiaryResponse> getFitnessDiaries(Integer year, Integer month, Integer day, Long creatorId) {
        Iterable<FitnessDiary> fitnessDiaries = fitnessDiaryRepository.findByYearAndMonthAndDayAndCreatorId(year, month, day, creatorId);
        Iterable<FitnessDiaryResponse> fitnessDiaryResponses = StreamSupport.stream(fitnessDiaries.spliterator(), false)
                .map(fitnessDiary -> FitnessDiaryResponse.builder().fitnessDiary(fitnessDiary).build()).collect(Collectors.toList());
        return fitnessDiaryResponses;
    }
    //Iterable<FitnessDiary> 페이징이 필요없을 경우 사용

    @Override
    @Transactional
    public FitnessDiaryResponse postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest, Long creatorId) {
        FitnessDiary fitnessDiary = FitnessDiary.builder()
                .creatorId(creatorId)
                .fitnessDiaryPostRequest(fitnessDiaryPostRequest)
                .build();
        FitnessDiary saved = fitnessDiaryRepository.save(fitnessDiary);
        return FitnessDiaryResponse.builder()
                .fitnessDiary(fitnessDiary)
                .build();
    }

    @Override
    @Transactional
    public FitnessDiaryResponse putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest, Long id) {
        FitnessDiary fitnessDiary = fitnessDiaryRepository.findById(id).orElseThrow();

        FitnessDiary beforeUpdate = FitnessDiary.builder()
                .fitnessDiary(fitnessDiary)
                .fitnessDiaryPutRequest(fitnessDiaryPutRequest)
                .build();
        FitnessDiary updated = fitnessDiaryRepository.save(beforeUpdate);
        return FitnessDiaryResponse.builder()
                .fitnessDiary(updated)
                .build();
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
