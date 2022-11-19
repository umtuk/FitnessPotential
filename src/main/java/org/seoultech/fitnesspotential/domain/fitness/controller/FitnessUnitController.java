package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.unit.FitnessUnitDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.unit.FitnessUnitResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FitnessUnitController {

    @GetMapping("/{id}")
    public ResponseEntity<FitnessUnitResponse> getFitnessUnit(@PathVariable Long id) {

        return null;
    }

    @PostMapping
    public ResponseEntity<FitnessUnitResponse> postFitnessUnit(@RequestBody @Valid FitnessUnitPostRequest fitnessUnitPostRequest) {

        return null;
    }

    @PutMapping
    public ResponseEntity<FitnessUnitResponse> putFitnessUnit(@RequestBody @Valid FitnessUnitPutRequest fitnessUnitPutRequest) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FitnessUnitDeleteResponse> deleteFitnessUnit(@PathVariable Long id) {

        return null;
    }
}
