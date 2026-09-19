//package com.medix.ai_medical_as.service;
//
//import com.medix.ai_medical_as.entity.MedicalDocument;
//import com.medix.ai_medical_as.repository.MedicalDocumentRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MedicalDocumentService {
//
//    private final MedicalDocumentRepository repository;
//
//    public MedicalDocumentService(
//            MedicalDocumentRepository repository) {
//        this.repository = repository;
//    }
//
//    public MedicalDocument saveDocument(String content) {
//
//        MedicalDocument document =
//                new MedicalDocument(content);
//
//        return repository.save(document);
//    }
//} updated in 3.4.4 or embedding

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

        // 1. Save the document
        MedicalDocument document =
                new MedicalDocument(content);

        document = documentRepository.save(document);

        // 2. Generate embedding
        List<Double> embedding =
                embeddingService.generateEmbedding(content);

        // 3. Store embedding in pgvector
        embeddingRepository.saveEmbedding(
                document.getId(),
                embedding
        );

        return document;
    }
}

