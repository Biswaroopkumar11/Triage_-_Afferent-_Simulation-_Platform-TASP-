package com.medix.ai_medical_as.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateMessageRequest {

    @NotBlank(message = "Message content is required")
    private String content;

    public CreateMessageRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}