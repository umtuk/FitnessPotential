package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineSummaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessRoutineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFitnessRoutineService implements FitnessRoutineService {
    @Override
    public FitnessRoutineResponse getFitnessRoutine(Long id) {
        return null;
    }

    @Override
    public Page<FitnessRoutineSummaryResponse> getFitnessRoutines(Pageable pageable) {
        return null;
    }

    @Override
    public FitnessRoutineResponse postFitnessRoutine(FitnessRoutinePostRequest fitnessRoutinePostRequest) {
        return null;
    }

    @Override
    public FitnessRoutineResponse putFitnessRoutine(FitnessRoutinePutRequest fitnessRoutinePutRequest) {
        return null;
    }

    @Override
    public FitnessRoutineDeleteResponse deleteFitnessRoutine(Long id) {
        return null;
    }
}
