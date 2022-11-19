package org.seoultech.fitnesspotential.domain.food.service;

import org.seoultech.fitnesspotential.domain.food.dto.request.diary.FoodDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.food.dto.request.diary.FoodDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.food.dto.response.diary.FoodDiaryResponse;
import org.seoultech.fitnesspotential.domain.food.dto.response.diary.FoodDiarySummaryResponse;
import org.seoultech.fitnesspotential.domain.food.repository.FoodDiaryDeleteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodDiaryService {

    FoodDiaryResponse getFoodDiary(Long id);
    Page<FoodDiarySummaryResponse> getFoodDiaries(Pageable pageable);
    FoodDiaryResponse postFoodDiary(FoodDiaryPostRequest foodDiaryPostRequest);
    FoodDiaryResponse putFoodDiary(FoodDiaryPutRequest foodDiaryPutRequest);
    FoodDiaryDeleteResponse deleteFoodDiary(Long id);
}
