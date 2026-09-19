package com.medix.ai_medical_as.repository;

import com.medix.ai_medical_as.entity.Conversation;
import com.medix.ai_medical_as.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByConversationOrderByCreatedAtAsc(
            Conversation conversation
    );
}