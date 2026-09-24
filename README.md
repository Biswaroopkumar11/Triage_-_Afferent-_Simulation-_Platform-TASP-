# Triage – Afferent Simulation Platform (TASP)

An AI-powered full-stack healthcare assistance and care-access platform built with **Java, Spring Boot, PostgreSQL, pgvector, LangChain4j and Ollama**.

TASP combines conversational AI, medical-document retrieval, semantic/vector search and healthcare-facility management to create a foundation for an intelligent healthcare-access and care-coordination system.

The project is being developed with a modular architecture designed to support future **web, mobile, rural/low-connectivity and healthcare-workflow capabilities**.

---

## 🚀 Project Overview

The **Triage – Afferent Simulation Platform (TASP)** is an AI-powered healthcare platform that currently provides:

* User registration and authentication
* JWT-based authorization
* Conversational healthcare interaction
* Persistent conversations and messages
* Local LLM inference using Ollama
* Medical-document storage
* Text embedding generation
* PostgreSQL + pgvector vector storage
* Semantic/vector similarity search
* Retrieval-Augmented Generation (RAG)
* LangChain4j-based AI/RAG orchestration
* Healthcare facility management
* Healthcare service management
* Service-based healthcare-facility search
* Modular Spring Boot REST architecture

The long-term objective is to extend the platform from an AI medical-information assistant into an:

> **AI-Powered Healthcare Access & Care Coordination Platform**

designed to help connect a patient's healthcare concern with relevant medical information, healthcare services, appropriate facilities and future referral/follow-up workflows.

---

# ✨ Key Features

## AI & Medical Knowledge

* Conversational AI interaction
* Local AI inference using Ollama
* LLM integration
* Medical-document knowledge base
* Document embeddings
* PostgreSQL + pgvector
* Semantic similarity search
* Retrieval-Augmented Generation (RAG)
* LangChain4j integration
* Context-based medical-document retrieval

## Authentication & Security

* User registration
* User login
* JWT authentication
* Spring Security
* Protected REST APIs
* Secure handling of application secrets
* Separation of local configuration from source-controlled code

## Conversation Management

* Persistent conversations
* Persistent messages
* User-specific conversation access
* AI-generated responses through the backend

## Healthcare Facility Management

The platform now includes a healthcare-facility management layer.

Supported information includes:

* Facility name
* Facility type
* Address
* City
* District
* State
* Pincode
* Latitude
* Longitude
* Contact number
* Public/private classification
* Active/inactive status

## Healthcare Service Management

A facility can provide multiple healthcare services.

Example:

```text
Community Health Centre
├── General Medicine
├── Emergency Care
├── Laboratory
├── Pharmacy
└── Teleconsultation
```

The system currently supports:

* Adding services to a healthcare facility
* Listing services provided by a facility
* Tracking service availability
* Searching facilities by available service
* Consistent ID-based result ordering

---

# 🏗️ Current Architecture

```text
User
  ↓
Client Application
  ↓
Spring Boot REST API
  ↓
Spring Security + JWT
  ↓
Application Services
  ├── User / Authentication
  ├── Conversation / Message
  ├── Medical Document
  ├── AI / RAG
  └── Healthcare Facility / Service
  ↓
AI / Retrieval Layer
  ↓
LangChain4j
  ├── Embeddings
  ├── Retrieval
  └── RAG orchestration
  ↓
Ollama
  ├── Llama 3.2
  └── Nomic Embed Text
  ↓
PostgreSQL + pgvector
  ↓
Medical Knowledge / Vector Search
```

---

# 🧠 AI & RAG Architecture

The current medical-information workflow is:

```text
Medical Documents
       ↓
Document Processing
       ↓
Text Embeddings
       ↓
PostgreSQL + pgvector
       ↓
Semantic Similarity Search
       ↓
Relevant Medical Context
       ↓
LangChain4j RAG Pipeline
       ↓
Ollama / LLM
       ↓
Grounded AI Response
```

User-query workflow:

```text
User Question
      ↓
Query Embedding
      ↓
Vector Search
      ↓
Relevant Medical Documents
      ↓
Context Assembly
      ↓
LangChain4j
      ↓
LLM / Ollama
      ↓
AI Response
```

The RAG layer is intended to ground responses in the configured medical knowledge base rather than relying only on unrestricted free-form generation.

---

# 🏥 Healthcare Access Foundation

The newly added healthcare module introduces a service-to-facility relationship.

```text
Patient Healthcare Need
        ↓
Required Healthcare Service
        ↓
Healthcare Facility
        ↓
Available Facility Service
        ↓
Location Information
        ↓
Future: Distance / Route
```

### Facility

```text
HealthcareFacility
```

Current facility attributes include:

```text
id
name
facilityType
address
city
district
state
pincode
latitude
longitude
phone
isPublic
isActive
```

### Facility Service

```text
FacilityService
```

Current service attributes include:

```text
id
facility
serviceName
available
```

---

# 🔌 Current REST APIs

## Authentication

The project contains authentication APIs for user registration and login through the existing security architecture.

## Conversations

```http
/api/conversations
/api/conversations/{id}/messages
```

## Healthcare Facilities

```http
POST /api/facilities
GET  /api/facilities
GET  /api/facilities/{id}
GET  /api/facilities/district/{district}
```

## Facility Services

```http
POST /api/facilities/{facilityId}/services
GET  /api/facilities/{facilityId}/services
GET  /api/facilities/services/search?service={serviceName}
```

The healthcare-facility APIs provide the foundation for future location-based facility discovery and healthcare-service matching.

---

# 🛠️ Tech Stack

| Category         | Technology                  |
| ---------------- | --------------------------- |
| Language         | Java                        |
| Backend          | Spring Boot                 |
| Security         | Spring Security, JWT        |
| Database         | PostgreSQL                  |
| Vector Search    | pgvector                    |
| ORM              | Spring Data JPA / Hibernate |
| AI Runtime       | Ollama                      |
| LLM              | Llama 3.2                   |
| Embedding Model  | Nomic Embed Text            |
| AI/RAG Framework | LangChain4j                 |
| Architecture     | REST API / Modular Backend  |
| Build Tool       | Maven                       |
| API Testing      | Postman                     |
| IDE              | IntelliJ IDEA               |
| Version Control  | Git / GitHub                |

---

# 📂 Project Structure

```text
src/main/java/com/medix/ai_medical_as
│
├── ai
│   ├── EmbeddingService.java
│   └── OllamaAIService.java
│
├── controller
│   ├── HealthcareFacilityController.java
│   ├── FacilityServiceController.java
│   └── ...
│
├── dto
│   ├── CreateFacilityRequest.java
│   ├── FacilityResponse.java
│   ├── FacilityServiceRequest.java
│   ├── FacilityServiceResponse.java
│   └── ...
│
├── entity
│   ├── HealthcareFacility.java
│   ├── FacilityService.java
│   └── ...
│
├── repository
│   ├── HealthcareFacilityRepository.java
│   ├── FacilityServiceRepository.java
│   └── ...
│
├── security
│   ├── JwtAuthenticationFilter.java
│   ├── JwtService.java
│   └── ...
│
└── service
    ├── HealthcareFacilityService.java
    ├── FacilityServiceManager.java
    └── ...
```

---

# ⚙️ Local Setup

## Prerequisites

Install:

* Java 25
* Maven
* PostgreSQL
* Ollama
* Git

---

## 1. Clone the Repository

```bash
git clone https://github.com/Biswaroopkumar11/Triage_-_Afferent-_Simulation-_Platform-TASP-.git
```

Then enter the project directory:

```bash
cd ai-medical-as
```

> Use your actual local project directory if you clone the repository under a different folder name.

---

## 2. Configure PostgreSQL

Create or use a local PostgreSQL database.

Enable the vector extension:

```sql
CREATE EXTENSION IF NOT EXISTS vector;
```

Configure:

```text
src/main/resources/application.properties
```

Use:

```text
src/main/resources/application-example.properties
```

as the configuration template where applicable.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=none
```

Replace the example credentials with your local configuration.

### Do not commit

* Database passwords
* JWT secrets
* API keys
* Private credentials
* Personal information
* Sensitive medical information

---

# 3. Configure Ollama

Ollama is used for local AI inference.

Pull the required models:

```bash
ollama pull llama3.2
ollama pull nomic-embed-text
```

Verify:

```bash
ollama list
```

The local Ollama service is expected to be available at:

```text
http://localhost:11434
```

Make sure Ollama is running before using AI/RAG functionality.

---

# 4. Build the Project

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

Build and test:

```bash
mvn clean test
```

or:

```bash
mvn clean install
```

---

# 5. Run the Application

```bash
mvn spring-boot:run
```

The Spring Boot backend currently runs on:

```text
http://localhost:8085
```

---

# 6. Test the APIs

Use Postman or another REST client.

Current functionality includes:

```text
User Registration
User Authentication
JWT Authentication
Conversation Management
Message Management
Medical Document Management
Embedding Generation
Vector Similarity Search
RAG / AI Integration
Healthcare Facility Management
Healthcare Service Management
Service-Based Facility Search
```

---

# 🔐 Security

The application uses Spring Security and JWT-based authentication to protect backend resources.

Sensitive configuration is kept outside version control.

The repository uses a configuration template such as:

```text
src/main/resources/application-example.properties
```

while local secrets remain in:

```text
src/main/resources/application.properties
```

Never commit:

```text
Database passwords
JWT secrets
API keys
Private credentials
Personal information
Sensitive medical information
```

For a production deployment, additional controls such as stronger secret management, security monitoring, audit logging and infrastructure hardening will be required.

---

# 📊 Current Database Concepts

The current backend contains data structures for:

```text
Users
Conversations
Messages
Medical Documents
Vector Embeddings
Healthcare Facilities
Facility Services
```

The healthcare-facility module currently establishes:

```text
HealthcareFacility
        │
        │ 1
        │
        │ *
        ▼
FacilityService
```

This allows one healthcare facility to provide multiple healthcare services.

---

# 📌 Project Status

## ✅ Implemented / Current

### Core Backend

* Spring Boot backend
* REST API architecture
* PostgreSQL integration
* Spring Data JPA
* User registration
* User authentication
* JWT security
* Conversation management
* Message management

### AI / RAG

* Ollama integration
* LLM integration
* Embedding generation
* Nomic Embed Text
* PostgreSQL + pgvector
* Vector similarity search
* Medical document knowledge base
* LangChain4j integration
* RAG pipeline foundation

### Healthcare Access

* Healthcare facility entity
* Facility CRUD APIs
* Healthcare service entity
* Facility-service relationship
* Service availability
* Facility service APIs
* Service-based facility search
* Latitude/longitude storage
* Public/private facility classification
* Active/inactive facility status

---

# 🚧 Next Development Modules

The project is being expanded incrementally toward the SIH healthcare-access problem domain.

### 1. Location-Based Facility Discovery

```text
Patient Location
       ↓
Healthcare Facilities
       ↓
Distance Calculation
       ↓
Required Service Filter
       ↓
Suitable Facilities
```

Planned technologies:

* PostGIS
* Geospatial queries
* Mapping/routing integration

### 2. Digital Triage

```text
Symptoms
   ↓
Structured Information
   ↓
Triage Rules / Approved Protocols
   ↓
Urgency Category
   ↓
Recommended Next Step
```

The system is intended to provide preliminary assistance and should not be treated as an autonomous medical diagnosis system.

### 3. Patient Health Profile & Timeline

Planned components:

* Patient profile
* Health history
* Symptoms
* Encounters
* Medical documents
* Referrals
* Follow-ups

### 4. Referral & Care Coordination

```text
Initial Assessment
      ↓
Referral
      ↓
Destination Facility
      ↓
Appointment / Consultation
      ↓
Referral Completion
      ↓
Follow-up
```

### 5. Appointment & Queue Management

Planned:

* Service/department selection
* Appointment slots
* Booking
* Queue/token management
* Appointment status

### 6. Diagnostic Coordination

Planned:

* Diagnostic facility management
* Available tests/services
* Test booking
* Diagnostic result/document workflow

### 7. Medicine Availability

Planned:

* Facility medicine inventory
* Stock availability
* Availability search

Availability will only be described as real-time when supported by a verified live data source.

### 8. High-Risk Follow-Up

Planned:

* Follow-up schedules
* Reminders
* Health-worker tracking
* High-risk monitoring workflows

### 9. Healthcare Worker & Facility Dashboards

Planned roles:

```text
PATIENT
HEALTH_WORKER
DOCTOR
FACILITY_ADMIN
DISTRICT_ADMIN
```

### 10. Rural / Low-Connectivity Support

Planned:

* React/PWA client
* Service Worker
* IndexedDB
* Offline-first workflows
* Sync queue
* Data synchronization

### 11. Multilingual & Voice Support

Planned:

* Hindi
* English
* Regional-language support
* Speech-to-text
* Text-to-speech
* Simplified healthcare explanations

### 12. Teleconsultation

Planned:

* WebRTC-based video consultation
* Appointment-linked consultation sessions

### 13. Health-Data Interoperability

Planned:

* HL7 FHIR-aligned data structures
* Interoperability architecture
* Future ABDM-compatible integration where technically and institutionally applicable

### 14. Deployment & Monitoring

Planned:

* Docker
* Cloud deployment
* HTTPS
* Monitoring
* Logging
* Production security hardening

---

# 🔮 Planned Future Architecture

The long-term platform is intended to evolve from an AI medical assistant into an integrated healthcare-access and care-coordination system:

```text
                        PATIENT
                           │
                           ▼
                  AI HEALTH INTERFACE
                           │
                           ▼
                MEDICAL KNOWLEDGE / RAG
                           │
                           ▼
                    DIGITAL TRIAGE
                           │
                 ┌─────────┴─────────┐
                 │                   │
                 ▼                   ▼
          Required Service      Urgent Path
                 │
                 ▼
          FACILITY MATCHING
                 │
          ┌──────┼───────┐
          ▼      ▼       ▼
         PHC     CHC   DISTRICT
          │      │       │
          └──────┼───────┘
                 ▼
             ROUTING
                 │
                 ▼
       APPOINTMENT / QUEUE
                 │
                 ▼
          CONSULTATION
                 │
          ┌──────┴──────┐
          ▼             ▼
        Direct       Referral
          │             │
          └──────┬──────┘
                 ▼
          HEALTH TIMELINE
                 │
                 ▼
             FOLLOW-UP
```

---

# 🎯 SIH-Oriented Project Direction

The platform is being developed to address healthcare-access challenges through a combination of:

```text
AI-Assisted Health Information
             +
Evidence-Grounded Medical Retrieval
             +
Digital Triage
             +
Healthcare Service Matching
             +
Facility Discovery
             +
Route Assistance
             +
Referral Tracking
             +
Longitudinal Health Information
             +
Rural / Low-Connectivity Support
```

The intended role of the platform is to **complement healthcare professionals, frontline workers and public healthcare infrastructure**, not replace clinical diagnosis or professional medical decision-making.

---

# 🧪 Development & Testing

Recommended development flow:

```text
Implement
   ↓
Compile
   ↓
Unit / Integration Test
   ↓
Run Spring Boot
   ↓
Postman API Test
   ↓
Database Verification
   ↓
Commit to Git
   ↓
Push to GitHub
```

For API testing, Postman is currently used.

---

# 🔄 Git & Version Control

The project is maintained using:

```text
Git
GitHub
main branch
```

Development changes are committed incrementally so that major modules remain traceable.

Example commit style:

```text
Add healthcare facility and service management
Update README with healthcare facility module
```

---

# ⚠️ Medical Disclaimer

This project is intended for **educational, research and software-development purposes**.

It is not intended to:

* provide definitive medical diagnosis
* replace qualified healthcare professionals
* prescribe treatment independently
* replace emergency medical services

AI-generated information must be treated as preliminary assistance and should not be used as a substitute for professional medical evaluation.

---

# 👨‍💻 Author

**Biswaroop Kumar**

GitHub:

https://github.com/Biswaroopkumar11

---

# 📜 Project Status Summary

### Current working foundation

```text
Spring Boot
      +
PostgreSQL
      +
Spring Security + JWT
      +
Ollama
      +
LangChain4j
      +
RAG
      +
pgvector
      +
Medical Documents
      +
Healthcare Facilities
      +
Healthcare Services
```

### Development direction

```text
Current AI/RAG Platform
        ↓
Healthcare Access
        ↓
Digital Triage
        ↓
Facility & Service Matching
        ↓
Referral / Appointment / Queue
        ↓
Health Timeline & Follow-up
        ↓
Rural / Offline Support
        ↓
Teleconsultation
        ↓
FHIR / Future ABDM Interoperability
        ↓
National-scale Deployment Architecture
```

> **TASP is being developed incrementally. Features marked as planned are architectural targets and should not be interpreted as already implemented.**
