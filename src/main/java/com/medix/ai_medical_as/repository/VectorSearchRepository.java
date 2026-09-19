package com.medix.ai_medical_as.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class VectorSearchRepository {

    private final JdbcTemplate jdbcTemplate;

    public VectorSearchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> searchSimilar(
            List<Double> embedding,
            int limit) {

        String vectorString = embedding.toString();

        String sql = """
                SELECT
                    id,
                    content,
                    embedding <=> ?::vector AS distance
                FROM medical_documents
                WHERE embedding IS NOT NULL
                ORDER BY embedding <=> ?::vector
                LIMIT ?
                """;

        return jdbcTemplate.queryForList(
                sql,
                vectorString,
                vectorString,
                limit
        );
    }
}