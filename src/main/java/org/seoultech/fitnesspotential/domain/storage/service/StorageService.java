package org.seoultech.fitnesspotential.domain.storage.service;

import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePostRequest;
import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePutRequest;
import org.seoultech.fitnesspotential.domain.storage.dto.response.StorageDeleteResponse;
import org.seoultech.fitnesspotential.domain.storage.dto.response.StorageResponse;

public interface StorageService {

    StorageResponse getStorage(Long id);
    StorageResponse postStorage(StoragePostRequest StoragePostRequest);
    StorageResponse putStorage(StoragePutRequest StoragePutRequest);
    StorageDeleteResponse deleteStorage(Long id);
}
