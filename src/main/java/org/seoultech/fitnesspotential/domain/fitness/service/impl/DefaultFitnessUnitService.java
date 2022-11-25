package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutineResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.seoultech.fitnesspotential.domain.fitness.exception.FitnessUnitErrorMessage;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessRoutineRepository;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessUnitRepository;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultFitnessUnitService implements FitnessUnitService {

    private final FitnessUnitRepository fitnessUnitRepository;
    private final FitnessRoutineRepository fitnessRoutineRepository;

    @Autowired
    public DefaultFitnessUnitService(FitnessUnitRepository fitnessUnitRepository, FitnessRoutineRepository fitnessRoutineRepository) {
        this.fitnessUnitRepository = fitnessUnitRepository;
        this.fitnessRoutineRepository = fitnessRoutineRepository;
    }

    @Override
    @Transactional
    public Long getFitnessRoutineId(Long id) {
        FitnessUnit fitnessUnit = fitnessUnitRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(FitnessUnitErrorMessage.FITNESS_UNIT_NOT_FOUND.toString()));
        return fitnessUnit.getFitnessRoutine().getId();
    }

    @Override
    @Transactional
    public FitnessRoutineResponse postFitnessUnit(FitnessUnitPostRequest fitnessUnitPostRequest) {
        FitnessUnit fitnessUnit = FitnessUnit.builder()
                .fitnessUnitPostRequest(fitnessUnitPostRequest)
                .build();
        FitnessUnit posted = fitnessUnitRepository.save(fitnessUnit);
        Long fitnessRoutineId = posted.getFitnessRoutine().getId();
        FitnessRoutine fitnessRoutine = fitnessRoutineRepository.findById(fitnessRoutineId)
                .orElseThrow(() -> new IllegalArgumentException(FitnessUnitErrorMessage.FITNESS_UNIT_NOT_FOUND.toString()));
        return FitnessRoutineResponse.builder()
                .fitnessRoutine(fitnessRoutine)
                .build();
    }

    @Override
    @Transactional
    public FitnessRoutineResponse putFitnessUnit(FitnessUnitPutRequest fitnessUnitPutRequest, Long id) {
        FitnessUnit fitnessUnit = fitnessUnitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessUnitErrorMessage.FITNESS_UNIT_NOT_FOUND.toString()));

        fitnessUnit = FitnessUnit.builder()
                .fitnessUnit(fitnessUnit)
                .fitnessUnitPutRequest(fitnessUnitPutRequest)
                .build();

        FitnessUnit updated = fitnessUnitRepository.save(fitnessUnit);

        Long fitnessRoutineId = updated.getFitnessRoutine().getId();
        FitnessRoutine fitnessRoutine = fitnessRoutineRepository.findById(fitnessRoutineId)
                .orElseThrow(() -> new IllegalArgumentException(FitnessUnitErrorMessage.FITNESS_UNIT_NOT_FOUND.toString()));;
        return FitnessRoutineResponse.builder()
                .fitnessRoutine(fitnessRoutine)
                .build();
    }

    @Override
    @Transactional
    public void deleteFitnessUnit(Long id) {
        if(fitnessUnitRepository.existsById(id)){
            fitnessUnitRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException(FitnessUnitErrorMessage.FITNESS_UNIT_NOT_FOUND.toString());
        }
    }

    @Override
    public void deleteByFitnessRoutineId(Long fitnessRoutineId){
        fitnessUnitRepository.deleteByFitnessRoutineId(fitnessRoutineId);
    }
}
