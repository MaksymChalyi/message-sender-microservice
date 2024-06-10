package com.maksimkaxxl.messagesendermicroservice.repositories;

import com.maksimkaxxl.messagesendermicroservice.models.EmailMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmailMessageRepository extends CrudRepository<EmailMessage, String> {
    List<EmailMessage> findByEmailStatus(String emailStatus);
}
