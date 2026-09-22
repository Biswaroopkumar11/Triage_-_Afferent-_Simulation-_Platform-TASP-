
# Triage Afferent Simulation Platform(TASP)

An AI-powered full-stack medical assistant designed to provide conversational health information using AI, semantic search, and vector retrieval.

 # 🚀 Project Overview

The AI Medical Assistant combines a Spring Boot backend, PostgreSQL database, vector search, and locally hosted AI models to build an intelligent conversational healthcare application.

The project is being developed with a modular architecture that can later support web and mobile clients.

# ✨ Key Features

User registration and authentication

JWT-based authorization

Conversational AI interface

Persistent conversations and messages

AI response generation using Ollama

Medical document storage

Text embeddings for semantic search

PostgreSQL + pgvector vector storage

Vector similarity search

Modular Spring Boot backend

Local AI inference using Ollama


# 🏗️ Architecture

User

↓

Client Application

↓

Spring Boot REST API

↓

Authentication & Authorization

↓

Conversation / Message Services

↓

AI Service

↓

Ollama

|

├── Llama 3.2

└── Nomic Embed Text

↓

Text Embeddings

↓

PostgreSQL + pgvector

↓

Vector Similarity Search

↓

Relevant Documents



# 🛠️ Tech Stack

Language: Java

Backend: Spring Boot

Security: Spring Security, JWT

Database: PostgreSQL

Vector Database: pgvector

AI Runtime: Ollama

LLM: Llama 3.2

Embedding Model: Nomic Embed Text

ORM: Spring Data JPA

API: REST

Build Tool: Maven

Testing/API Tool: Postman

IDE: IntelliJ IDEA

Version Control: Git, GitHub


📂 Project Structure

src/main/java/com/medix/ai_medical_as
│
├── ai
│   ├── EmbeddingService.java
│   └── OllamaAIService.java
│
├── controller
├── dto
├── entity
├── repository
├── security
└── service

# ⚙️ Local Setup

Prerequisites

Install the following:

Java 25

Maven

PostgreSQL

Ollama

Git


## 1. Clone the Repository

git clone https://github.com/Biswaroopkumar11/Triage_-_Afferent-_Simulation-_Platform-TASP-

cd ai-medical-assistant

2. Configure PostgreSQL

Use your local PostgreSQL database.

Enable the pgvector extension:

CREATE EXTENSION IF NOT EXISTS vector;

Create:

src/main/resources/application.properties

Use application-example.properties as a template.

Example:

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database

spring.datasource.username=postgres

spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=none


> Replace the example database credentials with your local values.



Do not commit application.properties to GitHub.

3. Configure Ollama

Ollama is used to run the AI models locally.

Pull the required models:

ollama pull llama3.2
ollama pull nomic-embed-text

Verify:

ollama list

The application uses the local Ollama server:

http://localhost:11434

Make sure Ollama is running before starting the application.

# 4. Build the Project

Check Java:

java -version

Check Maven:

mvn -version

Build the application:

mvn clean install

# 5. Run the Application

mvn spring-boot:run

The Spring Boot backend runs on:

http://localhost:8085

# 6. Test the APIs

Use Postman to test the REST APIs.

Current functionality includes:

User registration

User authentication

Conversation management

Message management

Medical document management

AI integration

Text embedding generation

Vector similarity search


# 🔐 Security

Sensitive configuration is excluded from Git.

The following file is kept local:

src/main/resources/application.properties

The repository contains:

src/main/resources/application-example.properties

as a configuration template.

Never commit:

Database passwords

JWT secrets

API keys

Private credentials

Personal information

Sensitive medical information


# 🧠 AI & Vector Search

The application uses Ollama for local AI processing.

The embedding workflow is:

Medical Text

↓

Nomic Embed Text

↓

Vector Embedding

↓

PostgreSQL + pgvector

↓

Cosine Similarity Search

↓

Relevant Medical Documents


User queries can also be converted into embeddings and compared against stored document vectors to retrieve semantically relevant information.

# 📌 Project Status


>Completed / Current

Spring Boot backend

User authentication

JWT security

Conversation management

Message management

Ollama integration

LLM integration

Embedding generation

PostgreSQL integration

pgvector integration

Vector similarity search


>Planned

LangChain4j integration

Complete RAG pipeline

Medical knowledge-base ingestion

Document chunking improvements

Advanced retrieval and context management

Web frontend

Android application

Deployment and cloud infrastructure


# 🔮 Future Architecture

The planned RAG architecture will extend the current vector-search implementation:

User Question

↓

Embedding Model

↓

Vector Search

↓

Relevant Medical Documents

↓

Context Assembly

↓

LLM

↓

AI Response

LangChain4j will be evaluated/integrated to simplify the orchestration of the AI, embedding, retrieval, and RAG components.

>⚠️ Disclaimer

This project is intended for educational and software-development purposes.

It is not intended to provide professional medical diagnosis, treatment, or emergency medical advice.

>👨‍💻 Author

Your Name

GitHub: https://github.com/Biswaroopkumar11


---

One important point


> implementation

Ollama

embeddings

pgvector

vector similarity search


from planned

LangChain4j

complete RAG

frontend

Android

deployment


