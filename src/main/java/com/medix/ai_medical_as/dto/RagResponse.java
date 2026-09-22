package com.medix.ai_medical_as.dto;

import java.util.List;

public class RagResponse {

    private String answer;
    private List<String> sources;

    public RagResponse(String answer, List<String> sources) {
        this.answer = answer;
        this.sources = sources;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getSources() {
        return sources;
    }
}