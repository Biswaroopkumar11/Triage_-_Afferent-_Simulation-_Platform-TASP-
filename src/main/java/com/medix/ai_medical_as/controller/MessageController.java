package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.dto.CreateMessageRequest;
import com.medix.ai_medical_as.dto.MessageResponse;
import com.medix.ai_medical_as.entity.User;
import com.medix.ai_medical_as.service.MessageService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations/{conversationId}/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // CREATE MESSAGE
    @PostMapping
    public ResponseEntity<List<MessageResponse>> createMessage(
            @PathVariable Long conversationId,
            @Valid @RequestBody CreateMessageRequest request,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        List<MessageResponse> response =
                messageService.createMessage(
                        conversationId,
                        user,
                        request
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    // GET ALL MESSAGES
    @GetMapping
    public ResponseEntity<List<MessageResponse>> getMessages(
            @PathVariable Long conversationId,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        List<MessageResponse> messages =
                messageService.getMessages(
                        conversationId,
                        user
                );

        return ResponseEntity.ok(messages);
    }
}