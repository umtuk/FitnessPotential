package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;

public interface FitnessUnitService {

    Long getFitnessRoutineId(Long id);
    FitnessUnit postFitnessUnit(FitnessUnitPostRequest fitnessUnitPostRequest);
    FitnessUnit putFitnessUnit(FitnessUnitPutRequest fitnessUnitPutRequest, Long id);
    void deleteFitnessUnit(Long id);
    void deleteByFitnessRoutineId(Long fitnessRoutineId);
}
