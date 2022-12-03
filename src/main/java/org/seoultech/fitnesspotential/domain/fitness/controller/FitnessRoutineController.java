package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessRoutineService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
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
    public ResponseEntity<FitnessRoutine> getFitnessRoutine(@PathVariable Long id, @RequestAttribute(name = "user") User user) {
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(id);
        if (fitnessRoutine.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        return new ResponseEntity<>(fitnessRoutineService.getFitnessRoutine(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<FitnessRoutine>> getFitnessRoutines(@RequestAttribute(name = "user") User user) {
        Iterable<FitnessRoutine> fitnessRoutines = fitnessRoutineService.getFitnessRoutines(user.getId());
        return !fitnessRoutines.iterator().hasNext() ?
                new ResponseEntity<>(fitnessRoutines, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(fitnessRoutines, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FitnessRoutine> postFitnessRoutine(@RequestBody @Validated FitnessRoutinePostRequest fitnessRoutinePostRequest, @RequestAttribute(name = "user") User user) {
        return new ResponseEntity<>(fitnessRoutineService.postFitnessRoutine(fitnessRoutinePostRequest, user.getId()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessRoutine> putFitnessRoutine(@RequestBody @Valid FitnessRoutinePutRequest fitnessRoutinePutRequest, @PathVariable Long id, @RequestAttribute(name = "user") User user) {
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(id);
        if (fitnessRoutine.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        return new ResponseEntity<>(fitnessRoutineService.putFitnessRoutine(fitnessRoutinePutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitnessRoutine(@PathVariable Long id, @RequestAttribute(name = "user") User user) {
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(id);
        if (fitnessRoutine.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        fitnessRoutineService.deleteFitnessRoutine(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
