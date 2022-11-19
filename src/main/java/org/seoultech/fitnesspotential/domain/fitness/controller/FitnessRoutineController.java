package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.routine.FitnessRoutineSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fitness/routine")
public class FitnessRoutineController {

    @GetMapping("/{id}")
    public ResponseEntity<FitnessRoutineResponse> getFitnessRoutine(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FitnessRoutineSummaryResponse>> getFitnessRoutines(@PageableDefault Pageable pageable) {

        return null;
    }

    @PostMapping
    public ResponseEntity<FitnessRoutineResponse> postFitnessRoutine(@RequestBody @Valid FitnessRoutinePostRequest fitnessRoutinePostRequest) {

        return null;
    }

    @PutMapping
    public ResponseEntity<FitnessRoutineResponse> putFitnessRoutine(@RequestBody @Valid FitnessRoutinePutRequest fitnessRoutinePutRequest) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FitnessRoutineDeleteResponse> deleteFitnessRoutine(@PathVariable Long id) {

        return null;
    }
}
