package com.medix.ai_medical_as.config;

import com.medix.ai_medical_as.rag.PgVectorContentRetriever;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RagConfig {

    @Bean
    public RetrievalAugmentor retrievalAugmentor(
            PgVectorContentRetriever contentRetriever) {

        return DefaultRetrievalAugmentor.builder()
                .contentRetriever(contentRetriever)
                .build();
    }
}