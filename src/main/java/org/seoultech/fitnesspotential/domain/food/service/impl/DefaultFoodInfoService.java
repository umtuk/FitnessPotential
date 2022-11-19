package org.seoultech.fitnesspotential.domain.food.service.impl;

import org.seoultech.fitnesspotential.domain.food.entity.FoodInfo;
import org.seoultech.fitnesspotential.domain.food.exception.FoodInfoErrorMessage;
import org.seoultech.fitnesspotential.domain.food.repository.FoodInfoRepository;
import org.seoultech.fitnesspotential.domain.food.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFoodInfoService implements FoodInfoService {

    private final FoodInfoRepository foodInfoRepository;

    @Autowired
    public DefaultFoodInfoService(FoodInfoRepository foodInfoRepository) {
        this.foodInfoRepository = foodInfoRepository;
    }

    @Override
    public FoodInfo getFoodInfo(Long id) {
        return foodInfoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FoodInfoErrorMessage.FOOD_INFO_NOT_FOUND.toString()));
    }

    @Override
    public Page<FoodInfo> getFoodInfos(Pageable pageable) {
        return foodInfoRepository.findAll(pageable);
    }
}
