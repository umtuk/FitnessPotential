package org.seoultech.fitnesspotential.domain.fitness.repository;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfoSummary;
import org.seoultech.fitnesspotential.global.repository.ReadOnlyPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessInfoSummaryRepository extends ReadOnlyPagingAndSortingRepository<FitnessInfoSummary, Long> {
    //View에 맞는거 제공
}
