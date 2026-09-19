package com.medix.ai_medical_as.ai;

import java.util.List;

public interface AIService {

//    String generateResponse(String userMessage);

    MedicalAIResponse generateResponse(List<String> conversationHistory);

}