package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.service.DocumentIngestionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class DocumentIngestionController {

    private final DocumentIngestionService ingestionService;

    public DocumentIngestionController(
            DocumentIngestionService ingestionService) {

        this.ingestionService = ingestionService;
    }

    @PostMapping(
            value = "/ingest",
            consumes = MediaType.TEXT_PLAIN_VALUE
    )
    public String ingest(
            @RequestParam String documentName,
            @RequestParam String source,
            @RequestBody String text) {

        ingestionService.ingestText(
                documentName,
                source,
                text
        );

        return "Document ingested successfully";
    }
}