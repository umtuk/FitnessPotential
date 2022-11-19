package org.seoultech.fitnesspotential.domain.storage.service.impl;

import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePostRequest;
import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePutRequest;
import org.seoultech.fitnesspotential.domain.storage.dto.response.StorageDeleteResponse;
import org.seoultech.fitnesspotential.domain.storage.dto.response.StorageResponse;
import org.seoultech.fitnesspotential.domain.storage.service.StorageService;
import org.springframework.stereotype.Service;

@Service
public class DefaultStorageService implements StorageService {
    @Override
    public StorageResponse getStorage(Long id) {
        return null;
    }

    @Override
    public StorageResponse postStorage(StoragePostRequest StoragePostRequest) {
        return null;
    }

    @Override
    public StorageResponse putStorage(StoragePutRequest StoragePutRequest) {
        return null;
    }

    @Override
    public StorageDeleteResponse deleteStorage(Long id) {
        return null;
    }
}
