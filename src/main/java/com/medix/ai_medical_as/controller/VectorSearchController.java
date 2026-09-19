package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.service.VectorSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class VectorSearchController {

    private final VectorSearchService vectorSearchService;

    public VectorSearchController(
            VectorSearchService vectorSearchService) {

        this.vectorSearchService = vectorSearchService;
    }

    @PostMapping
    public List<Map<String, Object>> search(
            @RequestBody String question) {

        return vectorSearchService.search(question, 5);
    }
}