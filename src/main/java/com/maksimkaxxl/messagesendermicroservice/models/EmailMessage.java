package com.maksimkaxxl.messagesendermicroservice.models;

import com.maksimkaxxl.messagesendermicroservice.models.enums.EmailStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Document(indexName = "emails")
public class EmailMessage {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String subject;
    private String content;
    private String recipientEmail;

    //    @Enumerated(EnumType.STRING)
    private EmailStatus emailStatus;

    private String errorMessage;
    private int retryCount;
    private long lastAttemptTime;
}
