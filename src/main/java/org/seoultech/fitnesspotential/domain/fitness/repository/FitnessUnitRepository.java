package org.seoultech.fitnesspotential.domain.fitness.repository;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessUnitRepository extends CrudRepository<FitnessUnit, Long> {
    void deleteByFitnessRoutineId(Long fitnessRoutineId);
}
