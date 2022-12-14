package org.seoultech.fitnesspotential.domain.food.service;

import org.seoultech.fitnesspotential.domain.food.dto.FoodInfoCategoryResponse;
import org.seoultech.fitnesspotential.domain.food.entity.FoodInfo;
import org.seoultech.fitnesspotential.domain.food.entity.FoodInfoCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodInfoService {

    FoodInfo getFoodInfo(Long id);

    Page<FoodInfo> getFoodInfos(Pageable pageable);
    Page<FoodInfo> getFoodInfos(String majorCategory, String detailedCategory, Pageable pageable);
    FoodInfoCategoryResponse getFoodInfoCategories();
}
