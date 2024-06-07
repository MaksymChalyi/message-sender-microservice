package com.maksimkaxxl.messagesendermicroservice.services.impl;

import com.maksimkaxxl.messagesendermicroservice.models.EmailMessage;
import com.maksimkaxxl.messagesendermicroservice.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {




    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {

    }
}
