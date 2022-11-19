package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.seoultech.fitnesspotential.domain.fitness.exception.FitnessDiaryErrorMessage;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessDiaryRepository;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFitnessDiaryService implements FitnessDiaryService {

    private final FitnessDiaryRepository fitnessDiaryRepository;

    @Autowired
    public DefaultFitnessDiaryService(FitnessDiaryRepository fitnessDiaryRepository){
        this.fitnessDiaryRepository = fitnessDiaryRepository;
    }

    @Override
    public FitnessDiary getFitnessDiary(Long id) {
        return fitnessDiaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessDiaryErrorMessage.FITNESS_DIARY_NOT_FOUND.toString()));
    }

    @Override
    public Page<FitnessDiary> getFitnessDiaries(Pageable pageable) {
        return fitnessDiaryRepository.findAll(pageable);
    }
    //Iterable<FitnessDiary> 페이징이 필요없을 경우 사용

    @Override
    public FitnessDiary postFitnessDiary(FitnessDiaryPostRequest fitnessDiaryPostRequest, Long creatorId) {
        FitnessDiary fitnessDiary = FitnessDiary.builder()
                .creatorId(creatorId)
                .fitnessDiaryPostRequest(fitnessDiaryPostRequest)
                .build();
        return fitnessDiaryRepository.save(fitnessDiary);
    }

    @Override
    public FitnessDiary putFitnessDiary(FitnessDiaryPutRequest fitnessDiaryPutRequest, Long id) {
        FitnessDiary fitnessDiary = fitnessDiaryRepository.findById(id).orElseThrow();

        FitnessDiary updated = FitnessDiary.builder()
                .fitnessDiary(fitnessDiary)
                .fitnessDiaryPutRequest(fitnessDiaryPutRequest)
                .build();
        return fitnessDiaryRepository.save(updated);
    }

    @Override
    public void deleteFitnessDiary(Long id) {
        if(fitnessDiaryRepository.existsById(id)) {
            fitnessDiaryRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException(FitnessDiaryErrorMessage.FITNESS_DIARY_NOT_FOUND.toString());
        }
    }
}
