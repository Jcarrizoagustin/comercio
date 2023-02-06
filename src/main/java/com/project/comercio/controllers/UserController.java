package com.project.comercio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/users")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity register(){
        return null;
    }


}
