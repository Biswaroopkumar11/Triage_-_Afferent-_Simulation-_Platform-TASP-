package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.ai.LangChainAIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/langchain")
public class LangChainTestController {

    private final LangChainAIService langChainAIService;

    public LangChainTestController(
            LangChainAIService langChainAIService) {

        this.langChainAIService = langChainAIService;
    }

    @PostMapping
    public String ask(@RequestBody String question) {

        return langChainAIService.ask(question);
    }
}