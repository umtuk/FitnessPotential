package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
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
    public ResponseEntity<FitnessRoutine> getFitnessRoutine(@PathVariable Long id) {

        return new ResponseEntity<>(fitnessRoutineService.getFitnessRoutine(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FitnessRoutine>> getFitnessRoutines(@PageableDefault Pageable pageable) {
        Page<FitnessRoutine> fitnessRoutines = fitnessRoutineService.getFitnessRoutines(pageable);
        return fitnessRoutines.isEmpty() ?
                new ResponseEntity<>(fitnessRoutines, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(fitnessRoutines, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FitnessRoutine> postFitnessRoutine(@RequestBody @Validated FitnessRoutinePostRequest fitnessRoutinePostRequest) {

        return new ResponseEntity<>(fitnessRoutineService.postFitnessRoutine(fitnessRoutinePostRequest, 0L), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessRoutine> putFitnessRoutine(@RequestBody @Valid FitnessRoutinePutRequest fitnessRoutinePutRequest, @PathVariable Long id) {

        return new ResponseEntity<>(fitnessRoutineService.putFitnessRoutine(fitnessRoutinePutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FitnessRoutine> deleteFitnessRoutine(@PathVariable Long id) {
        fitnessRoutineService.deleteFitnessRoutine(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
