package org.seoultech.fitnesspotential.domain.fitness.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfoSummary;
import org.seoultech.fitnesspotential.domain.fitness.repository.FitnessInfoSummaryRepository;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoSummaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@Slf4j
@Service
public class DefaultFitnessInfoSummaryService implements FitnessInfoSummaryService {

    private final FitnessInfoSummaryRepository fitnessInfoSummaryRepository;

    public DefaultFitnessInfoSummaryService(FitnessInfoSummaryRepository fitnessInfoSummaryRepository) {
        this.fitnessInfoSummaryRepository = fitnessInfoSummaryRepository;
    }

    @Override
    @Transactional
    public Page<FitnessInfoSummary> getFitnessInfoSummaries(String majorCategory, String detailedCategory, Pageable pageable) {
        if (majorCategory.equals("전체")) {
            return fitnessInfoSummaryRepository.findAll(pageable);
        }
        return fitnessInfoSummaryRepository.findByMajorCategoryAndDetailedCategory(majorCategory, detailedCategory, pageable);
    }
}
