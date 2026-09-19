package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.ai.EmbeddingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/embedding")
public class EmbeddingController {

    private final EmbeddingService embeddingService;

    public EmbeddingController(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    @PostMapping
    public List<Double> generateEmbedding(
            @RequestBody String text) {

        return embeddingService.generateEmbedding(text);
    }
}