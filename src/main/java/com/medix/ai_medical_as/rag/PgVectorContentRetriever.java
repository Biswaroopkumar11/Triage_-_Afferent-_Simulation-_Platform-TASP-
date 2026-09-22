package com.medix.ai_medical_as.rag;

import com.medix.ai_medical_as.ai.EmbeddingService;
import com.medix.ai_medical_as.repository.VectorSearchRepository;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.rag.query.Query;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PgVectorContentRetriever implements ContentRetriever {

    private final EmbeddingService embeddingService;
    private final VectorSearchRepository vectorSearchRepository;

    public PgVectorContentRetriever(
            EmbeddingService embeddingService,
            VectorSearchRepository vectorSearchRepository) {

        this.embeddingService = embeddingService;
        this.vectorSearchRepository = vectorSearchRepository;
    }

    @Override
    public List<Content> retrieve(Query query) {

        String question = query.text();

        System.out.println("========== RAG RETRIEVAL ==========");
        System.out.println("Question: " + question);

        List<Double> questionEmbedding =
                embeddingService.generateEmbedding(question);

        System.out.println(
                "Embedding size: " + questionEmbedding.size()
        );

        List<Map<String, Object>> results =
                vectorSearchRepository.searchSimilar(
                        questionEmbedding,
                        5
                );

        System.out.println(
                "Database results: " + results.size()
        );

        for (Map<String, Object> result : results) {
            System.out.println(
                    "ID: " + result.get("id")
                            + " | Content: " + result.get("content")
                            + " | Distance: " + result.get("distance")
            );
        }

        List<Content> contents = new ArrayList<>();

        for (Map<String, Object> result : results) {

            String text = (String) result.get("content");

            TextSegment segment =
                    TextSegment.from(text);

            contents.add(Content.from(segment));
        }

        System.out.println(
                "LangChain contents: " + contents.size()
        );

        System.out.println("===================================");

        return contents;
    }
}