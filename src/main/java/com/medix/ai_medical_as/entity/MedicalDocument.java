package com.medix.ai_medical_as.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_documents")
public class MedicalDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "chunk_index")
    private Integer chunkIndex;

    @Column(name = "source")
    private String source;


    // Required by JPA
    public MedicalDocument() {
    }


    // Constructor for document ingestion
    public MedicalDocument(
            String content,
            String documentName,
            Integer chunkIndex,
            String source) {

        this.content = content;
        this.documentName = documentName;
        this.chunkIndex = chunkIndex;
        this.source = source;
    }


    // Getters

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getDocumentName() {
        return documentName;
    }

    public Integer getChunkIndex() {
        return chunkIndex;
    }

    public String getSource() {
        return source;
    }


    // Setters

    public void setContent(String content) {
        this.content = content;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public void setChunkIndex(Integer chunkIndex) {
        this.chunkIndex = chunkIndex;
    }

    public void setSource(String source) {
        this.source = source;
    }
}