package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutineResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;

public interface FitnessUnitService {

    Long getFitnessRoutineId(Long id);
    FitnessRoutineResponse postFitnessUnit(FitnessUnitPostRequest fitnessUnitPostRequest);
    FitnessRoutineResponse putFitnessUnit(FitnessUnitPutRequest fitnessUnitPutRequest, Long id);
    void deleteFitnessUnit(Long id);
    void deleteByFitnessRoutineId(Long fitnessRoutineId);
}
