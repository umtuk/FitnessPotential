package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessRoutineService;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessUnitService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fitness/unit")
public class FitnessUnitController {

    private final FitnessUnitService fitnessUnitService;
    private final FitnessRoutineService fitnessRoutineService;

    @Autowired
    public FitnessUnitController(FitnessUnitService fitnessUnitService,
                                 FitnessRoutineService fitnessRoutineService){
        this.fitnessUnitService = fitnessUnitService;
        this.fitnessRoutineService = fitnessRoutineService;
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<FitnessUnit> getFitnessUnit(@PathVariable Long id) {
//        Long fitnessRoutineId = fitnessUnitService.getFitnessRoutineId(id);
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<FitnessUnit> postFitnessUnit(@RequestBody @Valid FitnessUnitPostRequest fitnessUnitPostRequest, @RequestAttribute(name = "user") User user) {
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(fitnessUnitPostRequest.getFitnessRoutineId());
        if (fitnessRoutine.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        return new ResponseEntity<>(fitnessUnitService.postFitnessUnit(fitnessUnitPostRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessUnit> putFitnessUnit(@RequestBody @Valid FitnessUnitPutRequest fitnessUnitPutRequest, @PathVariable Long id, @RequestAttribute(name = "user") User user) {
        Long fitnessRoutineId = fitnessUnitService.getFitnessRoutineId(id);
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(fitnessRoutineId);
        if (fitnessRoutine.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        return new ResponseEntity<>(fitnessUnitService.putFitnessUnit(fitnessUnitPutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitnessUnit(@PathVariable Long id, @RequestAttribute(name = "user") User user) {
        Long fitnessRoutineId = fitnessUnitService.getFitnessRoutineId(id);
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(fitnessRoutineId);
        if (fitnessRoutine.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        fitnessUnitService.deleteFitnessUnit(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
