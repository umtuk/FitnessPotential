package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.seoultech.fitnesspotential.domain.fitness.exception.FitnessInfoErrorMessage;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessInfoRepository;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFitnessInfoService implements FitnessInfoService {

    private final FitnessInfoRepository fitnessInfoRepository;

    @Autowired
    public DefaultFitnessInfoService(FitnessInfoRepository fitnessInfoRepository) {
        this.fitnessInfoRepository = fitnessInfoRepository;
    }

    @Override
    public FitnessInfo getFitnessInfo(Long id) {
        return fitnessInfoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(FitnessInfoErrorMessage.FITNESS_INFO_NOT_FOUND.toString()));
    }

    @Override
    public FitnessInfo postFitnessInfo(FitnessInfoPostRequest fitnessInfoPostRequest, Long creatorId) {
        FitnessInfo fitnessInfo = FitnessInfo.builder()
                .creatorId(creatorId)
                .fitnessInfoPostRequest(fitnessInfoPostRequest)
                .build();
        return fitnessInfoRepository.save(fitnessInfo);
    }

    @Override
    public FitnessInfo putFitnessInfo(FitnessInfoPutRequest fitnessInfoPutRequest, Long id) {
        FitnessInfo fitnessInfo = fitnessInfoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessInfoErrorMessage.FITNESS_INFO_NOT_FOUND.toString()));

        FitnessInfo updated = FitnessInfo.builder()
                .fitnessInfo(fitnessInfo)
                .fitnessInfoPutRequest(fitnessInfoPutRequest)
                .build();
        return fitnessInfoRepository.save(updated);
    }

    @Override
    public void deleteFitnessInfo(Long id) {
        if(fitnessInfoRepository.existsById(id)){
            fitnessInfoRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException(FitnessInfoErrorMessage.FITNESS_INFO_NOT_FOUND.toString());
        }
    }
}
