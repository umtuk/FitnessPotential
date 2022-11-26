package org.seoultech.fitnesspotential.domain.fitness.repository;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessRoutineRepository extends CrudRepository<FitnessRoutine, Long> {
    Iterable<FitnessRoutine> findByCreatorId(Long creatorId);
}
