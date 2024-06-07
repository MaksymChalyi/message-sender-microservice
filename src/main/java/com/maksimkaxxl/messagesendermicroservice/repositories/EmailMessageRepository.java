package com.maksimkaxxl.messagesendermicroservice.repositories;

import com.maksimkaxxl.messagesendermicroservice.models.EmailMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailMessageRepository extends ElasticsearchRepository<EmailMessage, String> {

}
