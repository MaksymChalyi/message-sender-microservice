package com.maksimkaxxl.messagesendermicroservice.services.kafka.impl.KafkaConsumer;

import com.maksimkaxxl.messagesendermicroservice.services.kafka.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerImpl implements KafkaConsumer {
    @Override
    @KafkaListener(topics = "mailSender", groupId = "my_consumer")
    public void listen(String message) {
        System.out.println("Message received=" + message);
    }
}
