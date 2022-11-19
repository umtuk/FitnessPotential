package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiaryDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.diary.FitnessDiarySummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fitness/diary")
public class FitnessDiaryController {

    @GetMapping("/{id}")
    public ResponseEntity<FitnessDiaryResponse> getFitnessDiary(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FitnessDiarySummaryResponse>> getFitnessDiaries(@PageableDefault Pageable pageable) {

        return null;
    }

    @PostMapping
    public ResponseEntity<FitnessDiaryResponse> postFitnessDiary(@RequestBody @Valid FitnessDiaryPostRequest fitnessDiaryPostRequest) {

        return null;
    }

    @PutMapping
    public ResponseEntity<FitnessDiaryResponse> putFitnessDiary(@RequestBody @Valid FitnessDiaryPutRequest fitnessDiaryPutRequest) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FitnessDiaryDeleteResponse> deleteFitnessDiary(@PathVariable Long id) {

        return null;
    }
}
