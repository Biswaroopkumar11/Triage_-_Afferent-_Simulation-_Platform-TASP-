package com.medix.ai_medical_as.repository;

import com.medix.ai_medical_as.entity.MedicalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDocumentRepository
        extends JpaRepository<MedicalDocument, Long> {
}