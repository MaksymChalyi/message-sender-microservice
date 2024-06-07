package com.maksimkaxxl.messagesendermicroservice.services;

import com.maksimkaxxl.messagesendermicroservice.models.EmailMessage;

public interface EmailService {

    void sendEmailMessage(EmailMessage emailMessage);

}
