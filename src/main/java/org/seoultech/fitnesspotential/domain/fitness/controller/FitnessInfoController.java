package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfoSummary;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoService;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoSummaryService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/fitness/info")
public class FitnessInfoController {

    private final FitnessInfoService fitnessInfoService;
    private final FitnessInfoSummaryService fitnessInfoSummaryService;

    @Autowired
    public FitnessInfoController(FitnessInfoService fitnessInfoService, FitnessInfoSummaryService fitnessInfoSummaryService) {
        this.fitnessInfoService = fitnessInfoService;
        this.fitnessInfoSummaryService = fitnessInfoSummaryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitnessInfo> getFitnessInfo(@PathVariable Long id) {

        return new ResponseEntity<>(fitnessInfoService.getFitnessInfo(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FitnessInfoSummary>> getFitnessInfoSummaries(@RequestParam String majorCategory, @RequestParam String detailedCategory, @PageableDefault Pageable pageable) {
        Page<FitnessInfoSummary> fitnessInfoSummaries = fitnessInfoSummaryService.getFitnessInfoSummaries(majorCategory, detailedCategory, pageable);
        return fitnessInfoSummaries.isEmpty() ?
                new ResponseEntity<>(fitnessInfoSummaries, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(fitnessInfoSummaries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FitnessInfo> postFitnessInfo(@RequestBody @Valid FitnessInfoPostRequest fitnessInfoPostRequest, @RequestAttribute(name = "user") User user) {
        return new ResponseEntity<>(fitnessInfoService.postFitnessInfo(fitnessInfoPostRequest, user.getId()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessInfo> putFitnessInfo(@RequestBody @Valid FitnessInfoPutRequest fitnessInfoPutRequest, @PathVariable Long id, @RequestAttribute(name = "user") User user) {
        FitnessInfo fitnessInfo = fitnessInfoService.getFitnessInfo(id);
        if (fitnessInfo.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        return new ResponseEntity<>(fitnessInfoService.putFitnessInfo(fitnessInfoPutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitnessInfo(@PathVariable Long id, @RequestAttribute(name = "user") User user) {
        FitnessInfo fitnessInfo = fitnessInfoService.getFitnessInfo(id);
        if (fitnessInfo.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        fitnessInfoService.deleteFitnessInfo(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
