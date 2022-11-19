package org.seoultech.fitnesspotential.domain.food.service.impl;

import org.seoultech.fitnesspotential.domain.food.dto.request.diary.FoodDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.food.dto.request.diary.FoodDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.food.dto.response.diary.FoodDiaryResponse;
import org.seoultech.fitnesspotential.domain.food.dto.response.diary.FoodDiarySummaryResponse;
import org.seoultech.fitnesspotential.domain.food.repository.FoodDiaryDeleteResponse;
import org.seoultech.fitnesspotential.domain.food.service.FoodDiaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFoodDiaryService implements FoodDiaryService {
    @Override
    public FoodDiaryResponse getFoodDiary(Long id) {
        return null;
    }

    @Override
    public Page<FoodDiarySummaryResponse> getFoodDiaries(Pageable pageable) {
        return null;
    }

    @Override
    public FoodDiaryResponse postFoodDiary(FoodDiaryPostRequest foodDiaryPostRequest) {
        return null;
    }

    @Override
    public FoodDiaryResponse putFoodDiary(FoodDiaryPutRequest foodDiaryPutRequest) {
        return null;
    }

    @Override
    public FoodDiaryDeleteResponse deleteFoodDiary(Long id) {
        return null;
    }
}
