package org.seoultech.fitnesspotential.domain.fitness.repository;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessInfoRepository extends PagingAndSortingRepository<FitnessInfo, Long> {
}
