package org.seoultech.fitnesspotential.domain.storage.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.seoultech.fitnesspotential.domain.storage.entity.Storage;
import org.seoultech.fitnesspotential.domain.storage.exception.StorageErrorMessage;
import org.seoultech.fitnesspotential.domain.storage.repository.StorageRepository;
import org.seoultech.fitnesspotential.domain.storage.service.StorageService;
import org.seoultech.fitnesspotential.global.config.AwsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3StorageService implements StorageService {

    private final AwsConfig awsConfig;
    private final AmazonS3 amazonS3;
    private final StorageRepository storageRepository;

    @Autowired
    public S3StorageService(AwsConfig awsConfig, AmazonS3 amazonS3, StorageRepository storageRepository) {
        this.awsConfig = awsConfig;
        this.amazonS3 = amazonS3;
        this.storageRepository = storageRepository;
    }

    @Override
    @Transactional
    public Storage getStorage(Long id) {
        return storageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(StorageErrorMessage.STORAGE_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public Storage postStorage(MultipartFile multipartFile) throws IOException {
        String bucket = awsConfig.getBucket() + awsConfig.getDir();
        String s3FileName = UUID.randomUUID() + "_" + System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getInputStream().available());
        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objectMetadata);

        String url = amazonS3.getUrl(bucket, s3FileName).toString();
        Storage storage = Storage.builder()
                .url(url)
                .build();
        return storageRepository.save(storage);
    }

    @Override
    @Transactional
    public Storage putStorage(MultipartFile multipartFile, Long id) throws IOException {
        String bucket = awsConfig.getBucket() + awsConfig.getDir();
        Storage storage = getStorage(id);
        String deletedUrl = storage.getUrl();
        amazonS3.deleteObject(bucket, deletedUrl);

        String s3FileName = UUID.randomUUID() + "_" + System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getInputStream().available());
        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objectMetadata);

        String url = amazonS3.getUrl(bucket, s3FileName).toString();
        Storage updated = Storage.builder()
                .storage(storage)
                .url(url)
                .build();
        return storageRepository.save(updated);
    }

    @Override
    @Transactional
    public void deleteStorage(Long id) {
        String bucket = awsConfig.getBucket() + awsConfig.getDir();
        Storage storage = getStorage(id);
        String url = storage.getUrl();
        amazonS3.deleteObject(bucket, url);

        storageRepository.deleteById(id);
    }
}
