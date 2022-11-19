package org.seoultech.fitnesspotential.domain.food.service;

import org.seoultech.fitnesspotential.domain.food.dto.response.info.FoodInfoResponse;
import org.seoultech.fitnesspotential.domain.food.dto.response.info.FoodInfoSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodInfoService {

    FoodInfoResponse getFoodInfo(Long id);
    Page<FoodInfoSummaryResponse> getFoodInfos(Pageable pageable);
}
