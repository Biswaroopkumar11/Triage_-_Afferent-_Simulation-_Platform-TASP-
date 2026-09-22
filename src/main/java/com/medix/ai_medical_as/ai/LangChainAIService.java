package com.medix.ai_medical_as.ai;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class LangChainAIService {

    private final ChatModel chatModel;

    public LangChainAIService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String ask(String question) {
        return chatModel.chat(question);
    }
}