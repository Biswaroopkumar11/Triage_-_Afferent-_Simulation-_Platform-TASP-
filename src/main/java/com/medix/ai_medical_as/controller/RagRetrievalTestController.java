package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.rag.PgVectorContentRetriever;
import dev.langchain4j.rag.query.Query;
import dev.langchain4j.rag.content.Content;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rag-test")
public class RagRetrievalTestController {

    private final PgVectorContentRetriever retriever;

    public RagRetrievalTestController(
            PgVectorContentRetriever retriever) {

        this.retriever = retriever;
    }

    @PostMapping
    public List<String> retrieve(
            @RequestBody String question) {

        List<Content> results =
                retriever.retrieve(Query.from(question));

        return results.stream()
                .map(content ->
                        content.textSegment().text()
                )
                .toList();
    }
}