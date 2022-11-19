package org.seoultech.fitnesspotential.domain.user.controller;

import org.seoultech.fitnesspotential.domain.user.dto.UserPostRequest;
import org.seoultech.fitnesspotential.domain.user.dto.UserPutRequest;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {

        return null;
    }
    
    @GetMapping("/my")
    public ResponseEntity<User> getUserDetails() {

        return null;
    }
    

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody @Valid UserPostRequest UserPostRequest) {

        return null;
    }

    @PutMapping
    public ResponseEntity<User> putUser(@RequestBody @Valid UserPutRequest UserPutRequest) {

        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser() {

        return null;
    }
}
