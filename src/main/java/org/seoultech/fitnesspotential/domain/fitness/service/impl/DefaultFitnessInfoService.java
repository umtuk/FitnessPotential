package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoSummaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFitnessInfoService implements FitnessInfoService {
    @Override
    public FitnessInfoResponse getFitnessInfo(Long id) {
        return null;
    }

    @Override
    public Page<FitnessInfoSummaryResponse> getFitnessInfos(Pageable pageable) {
        return null;
    }

    @Override
    public FitnessInfoResponse postFitnessInfo(FitnessInfoPostRequest fitnessInfoPostRequest) {
        return null;
    }

    @Override
    public FitnessInfoResponse putFitnessInfo(FitnessInfoPutRequest fitnessInfoPutRequest) {
        return null;
    }

    @Override
    public FitnessInfoDeleteResponse deleteFitnessInfo(Long id) {
        return null;
    }
}
