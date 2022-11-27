package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.info("{}", fitnessUnit);
        return fitnessUnit.getFitnessRoutine().getId();
    }

    @Override
    @Transactional
    public FitnessUnit postFitnessUnit(FitnessUnitPostRequest fitnessUnitPostRequest) {
        FitnessUnit fitnessUnit = FitnessUnit.builder()
                .fitnessUnitPostRequest(fitnessUnitPostRequest)
                .build();
        FitnessUnit posted = fitnessUnitRepository.save(fitnessUnit);
        return fitnessUnitRepository.save(fitnessUnit);
    }

    @Override
    @Transactional
    public FitnessUnit putFitnessUnit(FitnessUnitPutRequest fitnessUnitPutRequest, Long id) {
        FitnessUnit fitnessUnit = fitnessUnitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FitnessUnitErrorMessage.FITNESS_UNIT_NOT_FOUND.toString()));

        FitnessUnit updated = FitnessUnit.builder()
                .fitnessUnit(fitnessUnit)
                .fitnessUnitPutRequest(fitnessUnitPutRequest)
                .build();
        return fitnessUnitRepository.save(updated);
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
