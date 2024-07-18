package com.api.email_service.repositories.emailServer;

public interface EmailSenderUserCase {

    void sendEmail(String to , String subject , String body);
}
