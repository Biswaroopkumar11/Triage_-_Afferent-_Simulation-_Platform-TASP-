package com.medix.ai_medical_as.dto;

public class LoginResponse {

    private String token;
    private String tokenType;
    private Long userId;
    private String name;
    private String email;

    public LoginResponse(
            String token,
            String tokenType,
            Long userId,
            String name,
            String email) {

        this.token = token;
        this.tokenType = tokenType;
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}