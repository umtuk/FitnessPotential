package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutineResponse;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fitness/routine")
public class FitnessRoutineController {

    private final FitnessRoutineService fitnessRoutineService;

    @Autowired
    public FitnessRoutineController(FitnessRoutineService fitnessRoutineService){
        this.fitnessRoutineService = fitnessRoutineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitnessRoutineResponse> getFitnessRoutine(@PathVariable Long id) {

        return new ResponseEntity<>(fitnessRoutineService.getFitnessRoutine(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<FitnessRoutineResponse>> getFitnessRoutines() {
        Iterable<FitnessRoutineResponse> fitnessRoutines = fitnessRoutineService.getFitnessRoutines(0L);
        return !fitnessRoutines.iterator().hasNext() ?
                new ResponseEntity<>(fitnessRoutines, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(fitnessRoutines, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FitnessRoutineResponse> postFitnessRoutine(@RequestBody @Validated FitnessRoutinePostRequest fitnessRoutinePostRequest) {
        return new ResponseEntity<>(fitnessRoutineService.postFitnessRoutine(fitnessRoutinePostRequest, 0L), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessRoutineResponse> putFitnessRoutine(@RequestBody @Valid FitnessRoutinePutRequest fitnessRoutinePutRequest, @PathVariable Long id) {
        return new ResponseEntity<>(fitnessRoutineService.putFitnessRoutine(fitnessRoutinePutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitnessRoutine(@PathVariable Long id) {
        fitnessRoutineService.deleteFitnessRoutine(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
