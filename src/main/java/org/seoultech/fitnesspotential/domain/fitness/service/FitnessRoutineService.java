package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutineResponse;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FitnessRoutineService {

    FitnessRoutineResponse getFitnessRoutine(Long id);
    Iterable<FitnessRoutineResponse> getFitnessRoutines(Long creatorId);
    FitnessRoutineResponse postFitnessRoutine(FitnessRoutinePostRequest fitnessRoutinePostRequest, Long creatorId);
    FitnessRoutineResponse putFitnessRoutine(FitnessRoutinePutRequest fitnessRoutinePutRequest, Long id);
    void deleteFitnessRoutine(Long id);
}
