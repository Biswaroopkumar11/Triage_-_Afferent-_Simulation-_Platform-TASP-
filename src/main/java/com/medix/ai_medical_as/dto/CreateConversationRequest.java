package com.medix.ai_medical_as.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateConversationRequest {

    @NotBlank(message = "Title is required")
    private String title;

    public CreateConversationRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}