package org.seoultech.fitnesspotential.domain.food.service;

import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.food.entity.FoodDiary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodDiaryService {

    FoodDiary getFoodDiary(Long id);
    Iterable<FoodDiary> getFoodDiaries(Integer year, Integer month, Integer day, Long creatorId);
    FoodDiary postFoodDiary(FoodDiaryPostRequest foodDiaryPostRequest, Long creatorId);
    FoodDiary putFoodDiary(FoodDiaryPutRequest foodDiaryPutRequest, Long id);
    void deleteFoodDiary(Long id);
}
