package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;

public interface FitnessInfoService {

    FitnessInfo getFitnessInfo(Long id);
    FitnessInfo postFitnessInfo(FitnessInfoPostRequest fitnessInfoPostRequest, Long creatorId);
    FitnessInfo putFitnessInfo(FitnessInfoPutRequest fitnessInfoPutRequest, Long id);
    void deleteFitnessInfo(Long id);
}
