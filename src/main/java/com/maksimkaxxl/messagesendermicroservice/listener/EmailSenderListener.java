package com.maksimkaxxl.messagesendermicroservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maksimkaxxl.messagesendermicroservice.models.EmailMessage;
import com.maksimkaxxl.messagesendermicroservice.services.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSenderListener {

    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic.mailSender}")
    public void employeeAdded(String jsonMessage) {
        try {
            EmailMessage emailMessage = objectMapper.readValue(jsonMessage, EmailMessage.class);
            emailService.sendEmailMessage(emailMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
