package com.medix.ai_medical_as.service;

import com.medix.ai_medical_as.dto.ConversationResponse;
import com.medix.ai_medical_as.dto.CreateConversationRequest;
import com.medix.ai_medical_as.entity.Conversation;
import com.medix.ai_medical_as.entity.User;
import com.medix.ai_medical_as.repository.ConversationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    public ConversationService(
            ConversationRepository conversationRepository) {

        this.conversationRepository = conversationRepository;
    }

    public ConversationResponse createConversation(
            User user,
            CreateConversationRequest request) {

        LocalDateTime now = LocalDateTime.now();

        Conversation conversation = new Conversation();

        conversation.setUser(user);
        conversation.setTitle(request.getTitle());
        conversation.setCreatedAt(now);
        conversation.setUpdatedAt(now);

        Conversation savedConversation =
                conversationRepository.save(conversation);

        return new ConversationResponse(
                savedConversation.getId(),
                savedConversation.getTitle(),
                savedConversation.getCreatedAt(),
                savedConversation.getUpdatedAt()
        );
    }

    public List<ConversationResponse> getUserConversations(
            User user) {

        return conversationRepository
                .findByUserOrderByUpdatedAtDesc(user)
                .stream()
                .map(conversation ->
                        new ConversationResponse(
                                conversation.getId(),
                                conversation.getTitle(),
                                conversation.getCreatedAt(),
                                conversation.getUpdatedAt()
                        )
                )
                .toList();
    }


    public ConversationResponse getConversation(
            Long conversationId,
            User user) {

        Conversation conversation =
                conversationRepository
                        .findByIdAndUser(conversationId, user)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Conversation not found"));

        return new ConversationResponse(
                conversation.getId(),
                conversation.getTitle(),
                conversation.getCreatedAt(),
                conversation.getUpdatedAt()
        );
    }
}