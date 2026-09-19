package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.entity.MedicalDocument;
import com.medix.ai_medical_as.service.MedicalDocumentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class MedicalDocumentController {

    private final MedicalDocumentService service;

    public MedicalDocumentController(
            MedicalDocumentService service) {
        this.service = service;
    }

    @PostMapping
    public MedicalDocument createDocument(
            @RequestBody String content) {

        return service.saveDocument(content);
    }
}