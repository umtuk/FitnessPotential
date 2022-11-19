package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FitnessInfoService {

    FitnessInfoResponse getFitnessInfo(Long id);
    Page<FitnessInfoSummaryResponse> getFitnessInfos(Pageable pageable);
    FitnessInfoResponse postFitnessInfo(FitnessInfoPostRequest fitnessInfoPostRequest);
    FitnessInfoResponse putFitnessInfo(FitnessInfoPutRequest fitnessInfoPutRequest);
    FitnessInfoDeleteResponse deleteFitnessInfo(Long id);
}
