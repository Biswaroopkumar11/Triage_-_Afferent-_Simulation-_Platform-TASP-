package com.medix.ai_medical_as.service;

import com.medix.ai_medical_as.ai.AIService;
import com.medix.ai_medical_as.ai.MedicalAIResponse;
import com.medix.ai_medical_as.dto.CreateMessageRequest;
import com.medix.ai_medical_as.dto.MessageResponse;
import com.medix.ai_medical_as.entity.Conversation;
import com.medix.ai_medical_as.entity.Message;
import com.medix.ai_medical_as.entity.User;
import com.medix.ai_medical_as.repository.ConversationRepository;
import com.medix.ai_medical_as.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;
    private final AIService aiService;

    public MessageService(
            MessageRepository messageRepository,
            ConversationRepository conversationRepository,
            AIService aiService) {

        this.messageRepository = messageRepository;
        this.conversationRepository = conversationRepository;
        this.aiService = aiService;
    }

    public List<MessageResponse> createMessage(
            Long conversationId,
            User user,
            CreateMessageRequest request) {

        Conversation conversation =
                conversationRepository
                        .findByIdAndUser(conversationId, user)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Conversation not found"));

        // Save USER message
        Message userMessage = new Message();

        userMessage.setConversation(conversation);
        userMessage.setContent(request.getContent());
        userMessage.setSender("USER");
        userMessage.setCreatedAt(LocalDateTime.now());

        Message savedUserMessage =
                messageRepository.save(userMessage);


        // Get previous conversation messages
        List<Message> previousMessages =
                messageRepository
                        .findByConversationOrderByCreatedAtAsc(
                                conversation
                        );


        // Convert messages into AI conversation history
        List<String> conversationHistory =
                previousMessages.stream()
                        .map(message -> {
                            if ("USER".equals(message.getSender())) {
                                return "User: " + message.getContent();
                            } else {
                                return "Assistant: " + message.getContent();
                            }
                        })
                        .toList();


        // Generate AI response
//        String aiText =
//                aiService.generateResponse(
//                        conversationHistory
//                ); in milestone2.7.6
        MedicalAIResponse aiResponse = aiService.generateResponse(
                        conversationHistory
                );


        // Save AI message
        Message aiMessage = new Message();

        aiMessage.setConversation(conversation);
        aiMessage.setContent(
                aiResponse.getAnswer()
        );
        aiMessage.setSender("AI");
        aiMessage.setCreatedAt(LocalDateTime.now());

        Message savedAIMessage =
                messageRepository.save(aiMessage);


        // Update conversation time
        conversation.setUpdatedAt(LocalDateTime.now());

        conversationRepository.save(conversation);


        return List.of(

                new MessageResponse(
                        savedUserMessage.getId(),
                        savedUserMessage.getContent(),
                        savedUserMessage.getSender(),
                        savedUserMessage.getCreatedAt()
                ),

                new MessageResponse(
                        savedAIMessage.getId(),
                        savedAIMessage.getContent(),
                        savedAIMessage.getSender(),
                        savedAIMessage.getCreatedAt()
                )
        );
    }

    public List<MessageResponse> getMessages(
            Long conversationId,
            User user) {

        Conversation conversation =
                conversationRepository
                        .findByIdAndUser(conversationId, user)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Conversation not found"));

        return messageRepository
                .findByConversationOrderByCreatedAtAsc(conversation)
                .stream()
                .map(message ->
                        new MessageResponse(
                                message.getId(),
                                message.getContent(),
                                message.getSender(),
                                message.getCreatedAt()
                        ))
                .toList();
    }
}