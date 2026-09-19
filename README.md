# AI Medical Assistant

An AI-powered full-stack medical assistant designed to provide conversational health information using AI, semantic search, and Retrieval-Augmented Generation (RAG).

## 🚀 Project Overview

The AI Medical Assistant combines a Spring Boot backend, PostgreSQL database, vector search, and locally hosted AI models to build an intelligent conversational healthcare application.

The system is being designed with a scalable architecture that can later support web and mobile clients.


## ✨ Key Features

- User registration and authentication
- JWT-based authorization
- Conversational AI interface
- Persistent conversations and messages
- AI response generation using Ollama
- Medical document storage
- Text embeddings for semantic search
- PostgreSQL + pgvector vector storage
- Similarity-based medical information retrieval
- Retrieval-Augmented Generation (RAG)
- Modular Spring Boot backend
- Planned web and Android application support





## 🏗️ Architecture

```text
User
  ↓
Web / Android Client
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
  ↓
Embedding + Vector Search
  ↓
PostgreSQL + pgvector
  ↓
Relevant Medical Context
  ↓
AI Generated Response

## ⚙️ Local Setup

### Prerequisites

Make sure the following are installed:

- Java 25
- Maven
- PostgreSQL
- Ollama
- Git



## 🛠️ Tech Stack

- Backend:** Java, Spring Boot, Spring Security, Spring Data JPA
- **Database:** PostgreSQL, pgvector
- **AI:** Ollama, Llama, Nomic Embeddings
- **API:** REST APIs, JWT Authentication
- **Tools:** IntelliJ IDEA, Maven, Postman, Git, GitHub







### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/ai-medical-assistant.git
cd ai-medical-assistant




### 2. Configure PostgreSQL

Create a PostgreSQL database for the application.

For example:

```text
ai_medical_db

### 3. Configure Ollama

Ollama is used to run the AI language model and generate text embeddings locally.

#### Install Ollama

Install [Ollama](https://ollama.com/) on your system.

#### Download Required Models

```bash
ollama pull llama3.2
ollama pull nomic-embed-text



### 4. Build the Project

Make sure Java and Maven are installed and properly configured.

#### Verify Java

```bash
java -versjaion