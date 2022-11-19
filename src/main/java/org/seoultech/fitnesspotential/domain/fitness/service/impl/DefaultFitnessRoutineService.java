package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
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
    public FitnessRoutine getFitnessRoutine(Long id) {
        return fitnessRoutineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessRoutineErrorMessage.FITNESS_ROUTINE_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public Page<FitnessRoutine> getFitnessRoutines(Pageable pageable) {
        return fitnessRoutineRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public FitnessRoutine postFitnessRoutine(FitnessRoutinePostRequest fitnessRoutinePostRequest, Long creatorId) {
        FitnessRoutine fitnessRoutine = FitnessRoutine.builder()
                .fitnessRoutinePostRequest(fitnessRoutinePostRequest)
                .creatorId(creatorId)
                .build();

        return fitnessRoutineRepository.save(fitnessRoutine);
    }

    @Override
    @Transactional
    public FitnessRoutine putFitnessRoutine(FitnessRoutinePutRequest fitnessRoutinePutRequest, Long id) {
        FitnessRoutine fitnessRoutine = fitnessRoutineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessRoutineErrorMessage.FITNESS_ROUTINE_NOT_FOUND.toString()));

        FitnessRoutine updated = FitnessRoutine.builder()
                .fitnessRoutine(fitnessRoutine)
                .fitnessRoutinePutRequest(fitnessRoutinePutRequest)
                .build();
        return fitnessRoutineRepository.save(updated);
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
