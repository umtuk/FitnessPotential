package org.seoultech.fitnesspotential.domain.food.service.impl;

import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.food.entity.FoodDiary;
import org.seoultech.fitnesspotential.domain.food.exception.FoodDiaryErrorMessage;
import org.seoultech.fitnesspotential.domain.food.repository.FoodDiaryRepository;
import org.seoultech.fitnesspotential.domain.food.service.FoodDiaryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultFoodDiaryService implements FoodDiaryService {

    private final FoodDiaryRepository foodDiaryRepository;

    public DefaultFoodDiaryService(FoodDiaryRepository foodDiaryRepository) {
        this.foodDiaryRepository = foodDiaryRepository;
    }

    @Override
    public FoodDiary getFoodDiary(Long id) {
        return foodDiaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(FoodDiaryErrorMessage.FOOD_DIARY_NOT_FOUND.toString()));
    }

    @Override
    public Page<FoodDiary> getFoodDiaries(Pageable pageable) {
        return foodDiaryRepository.findAll(pageable);
    }

    @Override
    public FoodDiary postFoodDiary(FoodDiaryPostRequest foodDiaryPostRequest, Long creatorId) {
        FoodDiary foodDiary = FoodDiary.builder()
                .foodDiaryPostRequest(foodDiaryPostRequest)
                .creatorId(creatorId)
                .build();
        return foodDiaryRepository.save(foodDiary);
    }

    @Override
    public FoodDiary putFoodDiary(FoodDiaryPutRequest foodDiaryPutRequest, Long id) {
        FoodDiary foodDiary = foodDiaryRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException(FoodDiaryErrorMessage.FOOD_DIARY_NOT_FOUND.toString()));
        FoodDiary updated = FoodDiary.builder()
                .foodDiary(foodDiary)
                .foodDiaryPutRequest(foodDiaryPutRequest)
                .build();
        return foodDiaryRepository.save(updated);
    }

    @Override
    public void deleteFoodDiary(Long id) {
        if(foodDiaryRepository.existsById(id)){
            foodDiaryRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException(FoodDiaryErrorMessage.FOOD_DIARY_NOT_FOUND.toString());
        }
    }
}
