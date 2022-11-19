package org.seoultech.fitnesspotential.domain.storage.controller;

import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePostRequest;
import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePutRequest;
import org.seoultech.fitnesspotential.domain.storage.dto.response.StorageDeleteResponse;
import org.seoultech.fitnesspotential.domain.storage.dto.response.StorageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @GetMapping("/{id}")
    public ResponseEntity<StorageResponse> getStorage(@PathVariable Long id) {

        return null;
    }

    @PostMapping
    public ResponseEntity<StorageResponse> postStorage(@RequestBody @Valid StoragePostRequest StoragePostRequest) {

        return null;
    }

    @PutMapping
    public ResponseEntity<StorageResponse> putStorage(@RequestBody @Valid StoragePutRequest storagePutRequest) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StorageDeleteResponse> deleteStorage(@PathVariable Long id) {

        return null;
    }
}
