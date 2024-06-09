//package com.maksimkaxxl.messagesendermicroservice.config;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.Map;
//
//@Configuration
//public class KafkaTopicConfig {
//
//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;
//
//    @Value("${kafka.topic.mailSender}")
//    private String mailSender;
//
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = Map.of(
//                AdminClientConfig.BOOTSTRAP_CONTROLLERS_CONFIG, bootstrapAddress
//        );
//        return new KafkaAdmin(configs);
//    }
//
//    @Bean
//    public NewTopic mailSenderTopic() {
//        return new NewTopic(mailSender, 2, (short) 1);
//    }
//
//}
