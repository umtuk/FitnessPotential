package org.seoultech.fitnesspotential.domain.food.service.impl;

import org.seoultech.fitnesspotential.domain.food.dto.response.info.FoodInfoResponse;
import org.seoultech.fitnesspotential.domain.food.dto.response.info.FoodInfoSummaryResponse;
import org.seoultech.fitnesspotential.domain.food.service.FoodInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFoodInfoService implements FoodInfoService {
    @Override
    public FoodInfoResponse getFoodInfo(Long id) {
        return null;
    }

    @Override
    public Page<FoodInfoSummaryResponse> getFoodInfos(Pageable pageable) {
        return null;
    }
}
