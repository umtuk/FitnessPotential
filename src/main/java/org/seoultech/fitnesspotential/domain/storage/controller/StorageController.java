package org.seoultech.fitnesspotential.domain.storage.controller;

import com.amazonaws.util.IOUtils;
import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePostRequest;
import org.seoultech.fitnesspotential.domain.storage.dto.request.StoragePutRequest;
import org.seoultech.fitnesspotential.domain.storage.entity.Storage;
import org.seoultech.fitnesspotential.domain.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("/storage")
public class StorageController {

    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getStorage(@PathVariable Long id) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        Storage storage = storageService.getStorage(id);
        URL url = new URL(storage.getUrl());
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        InputStream fileIS = urlConn.getInputStream();
        httpHeaders.add("Content-Type", URLConnection.guessContentTypeFromStream(fileIS));
        return new ResponseEntity<>(IOUtils.toByteArray(fileIS), httpHeaders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> postStorage(@RequestParam("images") MultipartFile multipartFile) throws IOException {
        Storage storage = storageService.postStorage(multipartFile);
        return new ResponseEntity<>(storage.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> putStorage(@RequestParam("images") MultipartFile multipartFile, @PathVariable Long id) throws IOException {
        Storage storage = storageService.putStorage(multipartFile, id);
        return new ResponseEntity<>(storage.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStorage(@PathVariable Long id) {
        storageService.deleteStorage(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
