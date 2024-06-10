package com.maksimkaxxl.messagesendermicroservice.listener;

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
//    private final EmailService emailService;

    @KafkaListener(topics = "${kafka.topic.mailSender}")
    public void employeeAdded(String jsonMessage) {
        System.out.println("Message received=" + jsonMessage);
//        emailService.sendEmailMessage(jsonMessage);
        try {
            EmailMessage emailMessage = objectMapper.readValue(jsonMessage, EmailMessage.class);
//            System.out.println("EmailMessage=" + emailMessage);
            emailService.sendEmailMessage(emailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
