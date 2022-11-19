package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.unit.FitnessUnitDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.unit.FitnessUnitResponse;

public interface FitnessUnitService {

    FitnessUnitResponse getFitnessUnit(Long id);
    FitnessUnitResponse postFitnessUnit(FitnessUnitPostRequest fitnessUnitPostRequest);
    FitnessUnitResponse putFitnessUnit(FitnessUnitPutRequest fitnessUnitPutRequest);
    FitnessUnitDeleteResponse deleteFitnessUnit(Long id);
}
