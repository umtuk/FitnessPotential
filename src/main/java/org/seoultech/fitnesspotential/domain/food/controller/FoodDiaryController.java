package org.seoultech.fitnesspotential.domain.food.controller;

import org.seoultech.fitnesspotential.domain.food.dto.request.diary.FoodDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.food.dto.request.diary.FoodDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.food.dto.response.diary.FoodDiaryResponse;
import org.seoultech.fitnesspotential.domain.food.dto.response.diary.FoodDiarySummaryResponse;
import org.seoultech.fitnesspotential.domain.food.repository.FoodDiaryDeleteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/food/diary")
public class FoodDiaryController {

    @GetMapping("/{id}")
    public ResponseEntity<FoodDiaryResponse> getFoodDiary(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FoodDiarySummaryResponse>> getFoodDiaries(@PageableDefault Pageable pageable) {

        return null;
    }

    @PostMapping
    public ResponseEntity<FoodDiaryResponse> postFoodDiary(@RequestBody @Valid FoodDiaryPostRequest FoodDiaryPostRequest) {

        return null;
    }

    @PutMapping
    public ResponseEntity<FoodDiaryResponse> putFoodDiary(@RequestBody @Valid FoodDiaryPutRequest FoodDiaryPutRequest) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FoodDiaryDeleteResponse> deleteFoodDiary(@PathVariable Long id) {

        return null;
    }
}
