package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.ai.RagAssistant;
import com.medix.ai_medical_as.dto.RagResponse;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.service.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rag")
public class RagController {

    private final RagAssistant ragAssistant;

    public RagController(RagAssistant ragAssistant) {
        this.ragAssistant = ragAssistant;
    }

    @PostMapping
    public RagResponse chat(@RequestBody String question) {

        Result<String> result =
                ragAssistant.chat(question);

        List<String> sources =
                result.sources()
                        .stream()
                        .map(Content::textSegment)
                        .map(segment -> segment.text())
                        .toList();

        return new RagResponse(
                result.content(),
                sources
        );
    }
}