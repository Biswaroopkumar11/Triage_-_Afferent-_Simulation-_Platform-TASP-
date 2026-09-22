package com.medix.ai_medical_as.service;

import com.medix.ai_medical_as.ai.EmbeddingService;
import com.medix.ai_medical_as.entity.MedicalDocument;
import com.medix.ai_medical_as.repository.EmbeddingRepository;
import com.medix.ai_medical_as.repository.MedicalDocumentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentIngestionService {

    private final MedicalDocumentRepository documentRepository;
    private final EmbeddingService embeddingService;
    private final EmbeddingRepository embeddingRepository;
    private final TextChunker textChunker;

    public DocumentIngestionService(
            MedicalDocumentRepository documentRepository,
            EmbeddingService embeddingService,
            EmbeddingRepository embeddingRepository,
            TextChunker textChunker) {

        this.documentRepository = documentRepository;
        this.embeddingService = embeddingService;
        this.embeddingRepository = embeddingRepository;
        this.textChunker = textChunker;
    }

    public void ingestText(
            String documentName,
            String source,
            String text) {

        List<String> chunks =
                textChunker.split(text);

        System.out.println(
                "Total chunks created: "
                        + chunks.size()
        );

        int chunkIndex = 0;

        for (String chunk : chunks) {

            MedicalDocument document =
                    new MedicalDocument(
                            chunk,
                            documentName,
                            chunkIndex,
                            source
                    );

            document =
                    documentRepository.save(document);

            List<Double> embedding =
                    embeddingService.generateEmbedding(
                            chunk
                    );

            embeddingRepository.saveEmbedding(
                    document.getId(),
                    embedding
            );

            System.out.println(
                    "Stored chunk: "
                            + chunkIndex
            );

            chunkIndex++;
        }

        System.out.println(
                "Document ingestion completed: "
                        + documentName
        );
    }
}