package com.maksimkaxxl.messagesendermicroservice.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSenderListener {



//    private final EmailService emailService;

    @KafkaListener(topics = "${kafka.topic.mailSender}")
    public void employeeAdded(String jsonMessage){
        System.out.println("Message received=" +jsonMessage);
    }



}
