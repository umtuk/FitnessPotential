package org.seoultech.fitnesspotential.domain.food.controller;

import org.seoultech.fitnesspotential.domain.food.dto.response.info.FoodInfoResponse;
import org.seoultech.fitnesspotential.domain.food.dto.response.info.FoodInfoSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food/info")
public class FoodInfoController {

    @GetMapping("/{id}")
    public ResponseEntity<FoodInfoResponse> getFoodInfo(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FoodInfoSummaryResponse>> getFoodInfos(@PageableDefault Pageable pageable) {

        return null;
    }
}
