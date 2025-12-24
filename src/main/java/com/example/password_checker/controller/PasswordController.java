package com.example.password_checker.controller;

import com.example.password_checker.model.PasswordRequest;
import com.example.password_checker.model.PasswordResponse;
import com.example.password_checker.service.PasswordService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

   @PostMapping("/check-password")
public PasswordResponse checkPassword(@RequestBody PasswordRequest request) {

    if (request.getPassword() == null || request.getPassword().isBlank()) {
        return new PasswordResponse(
                "Invalid",
                0,
                List.of("Password cannot be empty"),
                List.of("Provide a valid password")
        );
    }

    return passwordService.analyzePassword(request.getPassword());
}

}
