package com.maksimkaxxl.messagesendermicroservice.services.email.impl;

import com.maksimkaxxl.messagesendermicroservice.models.EmailMessage;
import com.maksimkaxxl.messagesendermicroservice.models.enums.EmailStatus;
import com.maksimkaxxl.messagesendermicroservice.repositories.EmailMessageRepository;
import com.maksimkaxxl.messagesendermicroservice.services.email.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final EmailMessageRepository emailMessageRepository;

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(emailMessage.getRecipientEmail());
            helper.setSubject(emailMessage.getSubject());
            helper.setText(emailMessage.getContent(), true);
            mailSender.send(mimeMessage);
            emailMessage.setErrorMessage(null);
            emailMessage.setEmailStatus(EmailStatus.SENT);

        } catch (Exception e) {
            emailMessage.setEmailStatus(EmailStatus.FAILED);
            emailMessage.setErrorMessage(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        emailMessage.setLastAttemptTime(Instant.now());
        emailMessage.setRetryCount(Optional.of(emailMessage.getRetryCount()).orElse(0) + 1);
        emailMessageRepository.save(emailMessage);
    }


    @Scheduled(fixedRate = 300_000)
    public void retryFailedEmails() {
        List<EmailMessage> failedMessages = emailMessageRepository.findByEmailStatus(EmailStatus.FAILED);
        for (var emailMessage : failedMessages) {
            sendEmailMessage(emailMessage);
        }
    }

}
