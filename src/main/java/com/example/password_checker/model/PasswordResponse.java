package com.example.password_checker.model;

import java.util.List;

public class PasswordResponse {
    private String strength;
    private int score;
    private List<String> issues;
    private List<String> tips;

    public PasswordResponse(String strength, int score,
                            List<String> issues, List<String> tips) {
        this.strength = strength;
        this.score = score;
        this.issues = issues;
        this.tips = tips;
    }

    public String getStrength() { return strength; }
    public int getScore() { return score; }
    public List<String> getIssues() { return issues; }
    public List<String> getTips() { return tips; }
}
