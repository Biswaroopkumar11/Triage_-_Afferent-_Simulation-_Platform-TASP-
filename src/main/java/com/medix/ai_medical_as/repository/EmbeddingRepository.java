package com.medix.ai_medical_as.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmbeddingRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmbeddingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveEmbedding(Long id, List<Double> embedding) {

        String vectorString = embedding.toString();
//                .replace("[", "[")
//                .replace("]", "]");

        String sql = """
                UPDATE medical_documents
                SET embedding = ?::vector
                WHERE id = ?
                """;
        int updatedRows = jdbcTemplate.update(
                sql,
                vectorString,
                id
        );

        System.out.println(
                "Embedding rows updated: " + updatedRows
        );
    }
}