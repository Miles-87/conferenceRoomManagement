package com.management.controllers;

import com.management.model.dto.LoginDataDto;
import com.management.service.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDataDto loginDataDto) {
        return new ResponseEntity<>(securityService.login(loginDataDto), HttpStatus.OK);
    }
}
