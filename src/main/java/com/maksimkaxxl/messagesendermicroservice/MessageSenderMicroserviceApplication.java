package com.maksimkaxxl.messagesendermicroservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessageSenderMicroserviceApplication {

    public static void main(String[] args) {
//        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        SpringApplication.run(MessageSenderMicroserviceApplication.class, args);
    }

}
