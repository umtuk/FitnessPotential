package org.seoultech.fitnesspotential.view.storage.controller;

import org.seoultech.fitnesspotential.domain.storage.entity.Storage;
import org.seoultech.fitnesspotential.domain.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller()
@RequestMapping("/storage")
public class StorageViewController {

    private final StorageService storageService;

    @Autowired
    public StorageViewController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/{id}")
    public String getStorage(@PathVariable Long id, ModelMap model) throws IOException {
        Storage storage = storageService.getStorage(id);
        return "redirect:" + storage.getUrl();
    }

    @PostMapping
    public ResponseEntity<Long> postStorage(@RequestParam("images") MultipartFile multipartFile) throws IOException {
        Storage storage = storageService.postStorage(multipartFile);
        return new ResponseEntity<>(storage.getId(), HttpStatus.CREATED);
    }
}
