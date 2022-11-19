package org.seoultech.fitnesspotential.domain.food.controller;

import org.seoultech.fitnesspotential.domain.food.entity.FoodInfo;
import org.seoultech.fitnesspotential.domain.food.service.FoodInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food/info")
public class FoodInfoController {

    private final FoodInfoService foodInfoService;

    public FoodInfoController(FoodInfoService foodInfoService) {
        this.foodInfoService = foodInfoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodInfo> getFoodInfo(@PathVariable Long id) {

        return new ResponseEntity<>(foodInfoService.getFoodInfo(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FoodInfo>> getFoodInfos(@PageableDefault Pageable pageable) {
        Page<FoodInfo> foodInfos = foodInfoService.getFoodInfos(pageable);
        return foodInfos.isEmpty() ?
                new ResponseEntity<>(foodInfos, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(foodInfos, HttpStatus.OK);
    }
}
