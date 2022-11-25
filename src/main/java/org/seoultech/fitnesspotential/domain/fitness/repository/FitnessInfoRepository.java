package org.seoultech.fitnesspotential.domain.fitness.repository;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessInfoRepository extends CrudRepository<FitnessInfo, Long> {
}
