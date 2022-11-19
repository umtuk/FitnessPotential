package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fitness/diary")
public class FitnessDiaryController {

    private final FitnessDiaryService fitnessDiaryService;


    @Autowired
    public FitnessDiaryController(FitnessDiaryService fitnessDiaryService){
        this.fitnessDiaryService = fitnessDiaryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitnessDiary> getFitnessDiary(@PathVariable Long id) {
        return new ResponseEntity<>(fitnessDiaryService.getFitnessDiary(id), HttpStatus.OK);
    }

    @GetMapping("/search")//pageable -> size(한페이지에 몇개의 element를 담을건지), page, sort
    public ResponseEntity<Page<FitnessDiary>> getFitnessDiaries(@PageableDefault Pageable pageable) {
        Page<FitnessDiary> fitnessDiaries = fitnessDiaryService.getFitnessDiaries(pageable);
        return fitnessDiaries.isEmpty() ?
                new ResponseEntity<>(fitnessDiaries, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(fitnessDiaries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FitnessDiary> postFitnessDiary(@RequestBody @Valid FitnessDiaryPostRequest fitnessDiaryPostRequest) {

        return new ResponseEntity<>(fitnessDiaryService.postFitnessDiary(fitnessDiaryPostRequest, 0L), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FitnessDiary> putFitnessDiary(@RequestBody @Valid FitnessDiaryPutRequest fitnessDiaryPutRequest, Long id) {

        return new ResponseEntity<>(fitnessDiaryService.putFitnessDiary(fitnessDiaryPutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitnessDiary(@PathVariable Long id) {
        fitnessDiaryService.deleteFitnessDiary(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
