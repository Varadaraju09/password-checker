package com.example.password_checker.service;

import com.example.password_checker.model.PasswordResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public PasswordResponse analyzePassword(String password) {

        int score = 0;
        List<String> issues = new ArrayList<>();
        List<String> tips = new ArrayList<>();

        if (password.length() >= 8) score += 20;
        else issues.add("Password is too short");

        if (password.matches(".*[A-Z].*")) score += 20;
        else issues.add("Missing uppercase letter");

        if (password.matches(".*[a-z].*")) score += 20;
        else issues.add("Missing lowercase letter");

        if (password.matches(".*\\d.*")) score += 20;
        else issues.add("Missing number");

        if (password.matches(".*[@#$%!^&*].*")) score += 20;
        else issues.add("Missing special character");

        String strength;
        if (score >= 80) strength = "Strong";
        else if (score >= 50) strength = "Medium";
        else strength = "Weak";

        if (!strength.equals("Strong")) {
            tips.add("Use at least 8 characters");
            tips.add("Mix uppercase, lowercase, numbers and symbols");
            tips.add("Avoid common words");
        }

        return new PasswordResponse(strength, score, issues, tips);
    }
}
