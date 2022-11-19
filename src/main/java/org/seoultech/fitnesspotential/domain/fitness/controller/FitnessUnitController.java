package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fitness/unit")
public class FitnessUnitController {

    private final FitnessUnitService fitnessUnitService;

    @Autowired
    public FitnessUnitController(FitnessUnitService fitnessUnitService){
        this.fitnessUnitService = fitnessUnitService;
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<FitnessUnit> getFitnessUnit(@PathVariable Long id) {
//        Long fitnessRoutineId = fitnessUnitService.getFitnessRoutineId(id);
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<FitnessRoutine> postFitnessUnit(@RequestBody @Valid FitnessUnitPostRequest fitnessUnitPostRequest) {

        return new ResponseEntity<>(fitnessUnitService.postFitnessUnit(fitnessUnitPostRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessRoutine> putFitnessUnit(@RequestBody @Valid FitnessUnitPutRequest fitnessUnitPutRequest, @PathVariable Long id) {

        return new ResponseEntity<>(fitnessUnitService.putFitnessUnit(fitnessUnitPutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitnessUnit(@PathVariable Long id) {
        fitnessUnitService.deleteFitnessUnit(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
