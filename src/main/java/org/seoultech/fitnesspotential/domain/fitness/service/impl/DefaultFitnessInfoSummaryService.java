package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfoSummary;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessInfoSummaryRepository;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoSummaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFitnessInfoSummaryService implements FitnessInfoSummaryService {

    private final FitnessInfoSummaryRepository fitnessInfoSummaryRepository;

    public DefaultFitnessInfoSummaryService(FitnessInfoSummaryRepository fitnessInfoSummaryRepository) {
        this.fitnessInfoSummaryRepository = fitnessInfoSummaryRepository;
    }

    @Override
    public Page<FitnessInfoSummary> getFitnessInfoSummaries(Pageable pageable) {
        return fitnessInfoSummaryRepository.findAll(pageable);
    }
}
