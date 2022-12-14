package org.seoultech.fitnesspotential.domain.fitness.repository;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfoSummary;
import org.seoultech.fitnesspotential.global.repository.ReadOnlyPagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FitnessInfoSummaryRepository extends ReadOnlyPagingAndSortingRepository<FitnessInfoSummary, Long> {
    Page<FitnessInfoSummary> findByMajorCategoryAndDetailedCategory(String majorCategory, String detailedCategory, Pageable pageable);
    Iterable<FitnessInfoSummary> findByMajorCategoryAndDetailedCategory(String majorCategory, String detailedCategory);
}
