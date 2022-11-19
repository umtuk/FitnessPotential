package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfoSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FitnessInfoSummaryService {
    Page<FitnessInfoSummary> getFitnessInfoSummaries(Pageable pageable);
}
