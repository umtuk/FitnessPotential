package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;

public interface FitnessRoutineService {

    FitnessRoutine getFitnessRoutine(Long id);
    Iterable<FitnessRoutine> getFitnessRoutines(Long creatorId);
    FitnessRoutine postFitnessRoutine(FitnessRoutinePostRequest fitnessRoutinePostRequest, Long creatorId);
    FitnessRoutine putFitnessRoutine(FitnessRoutinePutRequest fitnessRoutinePutRequest, Long id);
    void deleteFitnessRoutine(Long id);
}
