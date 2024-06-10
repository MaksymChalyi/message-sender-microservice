package com.maksimkaxxl.messagesendermicroservice.services.email.impl;

import com.maksimkaxxl.messagesendermicroservice.models.EmailMessage;
import com.maksimkaxxl.messagesendermicroservice.models.enums.EmailStatus;
import com.maksimkaxxl.messagesendermicroservice.services.email.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
//    private final EmailMessageRepository emailMessageRepository;

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(emailMessage.getRecipientEmail());
            helper.setSubject(emailMessage.getSubject());
            helper.setText(emailMessage.getContent(), true);
            mailSender.send(mimeMessage);
            emailMessage.setEmailStatus(EmailStatus.SENT);
        } catch (MessagingException e) {
            emailMessage.setEmailStatus(EmailStatus.FAILED);
            emailMessage.setErrorMessage(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        emailMessage.setLastAttemptTime(Instant.now().toEpochMilli());
        emailMessage.setRetryCount(emailMessage.getRetryCount() + 1);
//        emailMessageRepository.save(emailMessage);
    }
}
