package com.medix.ai_medical_as.service;

import com.medix.ai_medical_as.ai.EmbeddingService;
import com.medix.ai_medical_as.repository.VectorSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VectorSearchService {

    private final EmbeddingService embeddingService;
    private final VectorSearchRepository vectorSearchRepository;

    public VectorSearchService(
            EmbeddingService embeddingService,
            VectorSearchRepository vectorSearchRepository) {

        this.embeddingService = embeddingService;
        this.vectorSearchRepository = vectorSearchRepository;
    }

    public List<Map<String, Object>> search(
            String question,
            int limit) {

        // 1. Convert question into embedding
        List<Double> questionEmbedding =
                embeddingService.generateEmbedding(question);

        // 2. Search PostgreSQL
        return vectorSearchRepository.searchSimilar(
                questionEmbedding,
                limit
        );
    }
}