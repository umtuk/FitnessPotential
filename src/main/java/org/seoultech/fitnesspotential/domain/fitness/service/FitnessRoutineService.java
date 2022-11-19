package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FitnessRoutineService {

    FitnessRoutine getFitnessRoutine(Long id);
    Page<FitnessRoutine> getFitnessRoutines(Pageable pageable);
    FitnessRoutine postFitnessRoutine(FitnessRoutinePostRequest fitnessRoutinePostRequest, Long creatorId);
    FitnessRoutine putFitnessRoutine(FitnessRoutinePutRequest fitnessRoutinePutRequest, Long id);
    void deleteFitnessRoutine(Long id);
}
