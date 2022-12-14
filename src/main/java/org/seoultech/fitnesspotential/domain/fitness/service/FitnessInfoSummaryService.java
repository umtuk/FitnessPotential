package org.seoultech.fitnesspotential.domain.fitness.service;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfoSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface FitnessInfoSummaryService {
    Page<FitnessInfoSummary> getFitnessInfoSummaries(String majorCategory, String detailedCategory, Pageable pageable);
}
