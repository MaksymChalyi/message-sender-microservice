package com.maksimkaxxl.messagesendermicroservice.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSenderListener {

//    @Value("${kafka.topic.mailSender}")
//    private String mailSenderTopic;

//    private final EmailService emailService;

    @KafkaListener(topics = "${kafka.topic.mailSender}")
    public void employeeAdded(String json){
        System.out.println(json);
    }

}
