package com.maksimkaxxl.messagesendermicroservice.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "emails")
public class EmailMessage {

    @Id
    private String id;
    private String subject;
    private String content;
    private String recipientEmail;
    private String status;
    private String errorMessage;
    private int retryCount;
    private long lastAttemptTime;
}
