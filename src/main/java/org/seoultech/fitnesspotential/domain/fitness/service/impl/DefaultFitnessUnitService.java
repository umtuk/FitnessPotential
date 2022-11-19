package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.unit.FitnessUnitDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.unit.FitnessUnitResponse;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessUnitService;
import org.springframework.stereotype.Service;

@Service
public class DefaultFitnessUnitService implements FitnessUnitService {
    @Override
    public FitnessUnitResponse getFitnessUnit(Long id) {
        return null;
    }

    @Override
    public FitnessUnitResponse postFitnessUnit(FitnessUnitPostRequest fitnessUnitPostRequest) {
        return null;
    }

    @Override
    public FitnessUnitResponse putFitnessUnit(FitnessUnitPutRequest fitnessUnitPutRequest) {
        return null;
    }

    @Override
    public FitnessUnitDeleteResponse deleteFitnessUnit(Long id) {
        return null;
    }
}
