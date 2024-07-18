package com.api.email_service.repositories.emailServer;


public interface EmailSenderGateway {

    void sendEmail(String to , String subject , String body);



}
