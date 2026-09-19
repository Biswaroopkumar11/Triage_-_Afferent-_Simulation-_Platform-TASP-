package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.dto.ConversationResponse;
import com.medix.ai_medical_as.dto.CreateConversationRequest;
import com.medix.ai_medical_as.entity.User;
import com.medix.ai_medical_as.service.ConversationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(
            ConversationService conversationService) {

        this.conversationService = conversationService;
    }

    @PostMapping
    public ResponseEntity<ConversationResponse> createConversation(
            @Valid @RequestBody CreateConversationRequest request,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        ConversationResponse response =
                conversationService.createConversation(
                        user,
                        request
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ConversationResponse>>
    getMyConversations(Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        List<ConversationResponse> conversations =
                conversationService.getUserConversations(user);

        return ResponseEntity.ok(conversations);
    }

    @GetMapping("/{conversationId}")
    public ResponseEntity<ConversationResponse> getConversation(
            @PathVariable Long conversationId,
            Authentication authentication) {

        User user =
                (User) authentication.getPrincipal();

        ConversationResponse response =
                conversationService.getConversation(
                        conversationId,
                        user
                );

        return ResponseEntity.ok(response);
    }

}