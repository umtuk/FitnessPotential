package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FitnessRoutineService {

    FitnessRoutineResponse getFitnessRoutine(Long id);
    Page<FitnessRoutineSummaryResponse> getFitnessRoutines(Pageable pageable);
    FitnessRoutineResponse postFitnessRoutine(FitnessRoutinePostRequest fitnessRoutinePostRequest);
    FitnessRoutineResponse putFitnessRoutine(FitnessRoutinePutRequest fitnessRoutinePutRequest);
    FitnessRoutineDeleteResponse deleteFitnessRoutine(Long id);
}
