package com.medix.ai_medical_as.service;

import com.medix.ai_medical_as.ai.EmbeddingService;
import com.medix.ai_medical_as.entity.MedicalDocument;
import com.medix.ai_medical_as.repository.EmbeddingRepository;
import com.medix.ai_medical_as.repository.MedicalDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDocumentService {

    private final MedicalDocumentRepository documentRepository;
    private final EmbeddingService embeddingService;
    private final EmbeddingRepository embeddingRepository;

    public MedicalDocumentService(
            MedicalDocumentRepository documentRepository,
            EmbeddingService embeddingService,
            EmbeddingRepository embeddingRepository) {

        this.documentRepository = documentRepository;
        this.embeddingService = embeddingService;
        this.embeddingRepository = embeddingRepository;
    }

    public MedicalDocument saveDocument(String content) {

        // 1. Create document with default metadata
        MedicalDocument document =
                new MedicalDocument(
                        content,
                        "manual-document",
                        0,
                        "manual"
                );

        // 2. Save document in PostgreSQL
        document =
                documentRepository.save(document);

        // 3. Generate embedding using Ollama
        List<Double> embedding =
                embeddingService.generateEmbedding(content);

        // 4. Store embedding in pgvector
        embeddingRepository.saveEmbedding(
                document.getId(),
                embedding
        );

        return document;
    }
}