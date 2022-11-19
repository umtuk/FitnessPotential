package org.seoultech.fitnesspotential.domain.community.repository;

import org.seoultech.fitnesspotential.domain.community.entity.CommunitySummary;
import org.seoultech.fitnesspotential.global.repository.ReadOnlyPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunitySummaryRepository extends ReadOnlyPagingAndSortingRepository<CommunitySummary, Long> {
}
