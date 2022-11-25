package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutineResponse;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.exception.FitnessRoutineErrorMessage;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessRoutineRepository;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessUnitRepository;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DefaultFitnessRoutineService implements FitnessRoutineService {

    private final FitnessRoutineRepository fitnessRoutineRepository;
    private final FitnessUnitRepository fitnessUnitRepository;

    @Autowired
    public DefaultFitnessRoutineService(FitnessRoutineRepository fitnessRoutineRepository, FitnessUnitRepository fitnessUnitRepository) {
        this.fitnessRoutineRepository = fitnessRoutineRepository;
        this.fitnessUnitRepository = fitnessUnitRepository;
    }

    @Override
    @Transactional
    public FitnessRoutineResponse getFitnessRoutine(Long id) {
        FitnessRoutine fitnessRoutine = fitnessRoutineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessRoutineErrorMessage.FITNESS_ROUTINE_NOT_FOUND.toString()));
        return FitnessRoutineResponse.builder()
                .fitnessRoutine(fitnessRoutine)
                .build();
    }

    @Override
    @Transactional
    public Iterable<FitnessRoutineResponse> getFitnessRoutines(Long creatorId) {
        Iterable<FitnessRoutine> fitnessRoutines = fitnessRoutineRepository.findByCreatorId(creatorId);
        Iterable<FitnessRoutineResponse> fitnessRoutineResponses = StreamSupport.stream(fitnessRoutines.spliterator(), false)
                .map(fitnessRoutine -> FitnessRoutineResponse.builder().fitnessRoutine(fitnessRoutine).build())
                .collect(Collectors.toList());
        return fitnessRoutineResponses;
    }

    @Override
    @Transactional
    public FitnessRoutineResponse postFitnessRoutine(FitnessRoutinePostRequest fitnessRoutinePostRequest, Long creatorId) {
        FitnessRoutine fitnessRoutine = FitnessRoutine.builder()
                .fitnessRoutinePostRequest(fitnessRoutinePostRequest)
                .creatorId(creatorId)
                .build();

        return FitnessRoutineResponse.builder()
                .fitnessRoutine(fitnessRoutine)
                .build();
    }

    @Override
    @Transactional
    public FitnessRoutineResponse putFitnessRoutine(FitnessRoutinePutRequest fitnessRoutinePutRequest, Long id) {
        FitnessRoutine fitnessRoutine = fitnessRoutineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessRoutineErrorMessage.FITNESS_ROUTINE_NOT_FOUND.toString()));

        FitnessRoutine updated = FitnessRoutine.builder()
                .fitnessRoutine(fitnessRoutine)
                .fitnessRoutinePutRequest(fitnessRoutinePutRequest)
                .build();

        return FitnessRoutineResponse.builder()
                .fitnessRoutine(updated)
                .build();
    }

    @Override
    @Transactional
    public void deleteFitnessRoutine(Long id) {
        if(fitnessRoutineRepository.existsById(id)){
            fitnessUnitRepository.deleteByFitnessRoutineId(id);
            fitnessRoutineRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException(FitnessRoutineErrorMessage.FITNESS_ROUTINE_NOT_FOUND.toString());
        }
    }
}
