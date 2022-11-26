package org.seoultech.fitnesspotential.domain.storage.service;

import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePostRequest;
import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePutRequest;
import org.seoultech.fitnesspotential.domain.storage.entity.Storage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {

    Storage getStorage(Long id);
    Storage postStorage(MultipartFile multipartFile) throws IOException;
    Storage putStorage(MultipartFile multipartFile, Long id) throws IOException;
    void deleteStorage(Long id);
}
