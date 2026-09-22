package com.medix.ai_medical_as.ai;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class EmbeddingService {

    private final RestClient restClient;

    public EmbeddingService() {

        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:11434")
                .build();
    }

    public List<Double> generateEmbedding(String text) {

        Map<String, Object> request = Map.of(
                "model", "nomic-embed-text",
                "input", text
        );

        Map response = restClient.post()
                .uri("/api/embed")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(Map.class);

        List<List<Double>> embeddings =
                (List<List<Double>>) response.get("embeddings");

        if (embeddings == null || embeddings.isEmpty()) {
            throw new RuntimeException(
                    "Ollama returned no embeddings"
            );
        }

        List<Double> embedding = embeddings.get(0);

        System.out.println(
                "Embedding dimensions: " + embedding.size()
        );

        return embedding;   }
}