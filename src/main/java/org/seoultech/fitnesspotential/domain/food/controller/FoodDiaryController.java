package org.seoultech.fitnesspotential.domain.food.controller;

import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.food.entity.FoodDiary;
import org.seoultech.fitnesspotential.domain.food.service.FoodDiaryService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/food/diary")
public class FoodDiaryController {

    private final FoodDiaryService foodDiaryService;

    public FoodDiaryController(FoodDiaryService foodDiaryService){
        this.foodDiaryService = foodDiaryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDiary> getFoodDiary(@PathVariable Long id, @RequestAttribute(name = "user") User user) {
        FoodDiary foodDiary = foodDiaryService.getFoodDiary(id);
        if (foodDiary.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        return new ResponseEntity<>(foodDiaryService.getFoodDiary(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<FoodDiary>> getFoodDiaries(@RequestParam Integer year, @RequestParam Integer month, @RequestParam Integer day, @RequestAttribute(name = "user") User user) {
        Iterable<FoodDiary> foodDiaries = foodDiaryService.getFoodDiaries(year, month, day, user.getId());
        return !foodDiaries.iterator().hasNext() ?
                new ResponseEntity<>(foodDiaries, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(foodDiaries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FoodDiary> postFoodDiary(@RequestBody @Valid FoodDiaryPostRequest foodDiaryPostRequest, @RequestAttribute(name = "user") User user) {
        return new ResponseEntity<>(foodDiaryService.postFoodDiary(foodDiaryPostRequest, user.getId()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodDiary> putFoodDiary(@RequestBody @Valid FoodDiaryPutRequest foodDiaryPutRequest, @PathVariable Long id, @RequestAttribute(name = "user") User user) {
        FoodDiary foodDiary = foodDiaryService.getFoodDiary(id);
        if (foodDiary.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        return new ResponseEntity<>(foodDiaryService.putFoodDiary(foodDiaryPutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodDiary(@PathVariable Long id, @RequestAttribute(name = "user") User user) {
        FoodDiary foodDiary = foodDiaryService.getFoodDiary(id);
        if (foodDiary.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        foodDiaryService.deleteFoodDiary(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
