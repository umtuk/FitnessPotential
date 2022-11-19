package org.seoultech.fitnesspotential.domain.fitness.controller;

import org.seoultech.fitnesspotential.domain.fitness.dto.request.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.request.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoDeleteResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoResponse;
import org.seoultech.fitnesspotential.domain.fitness.dto.response.info.FitnessInfoSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fitness/info")
public class FitnessInfoController {

    @GetMapping("/{id}")
    public ResponseEntity<FitnessInfoResponse> getFitnessInfo(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FitnessInfoSummaryResponse>> getFitnessInfos(@PageableDefault Pageable pageable) {

        return null;
    }

    @PostMapping
    public ResponseEntity<FitnessInfoResponse> postFitnessInfo(@RequestBody @Valid FitnessInfoPostRequest fitnessInfoPostRequest) {

        return null;
    }

    @PutMapping
    public ResponseEntity<FitnessInfoResponse> putFitnessInfo(@RequestBody @Valid FitnessInfoPutRequest fitnessInfoPutRequest) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FitnessInfoDeleteResponse> deleteFitnessInfo(@PathVariable Long id) {

        return null;
    }
}
