package com.api.email_service.service.emailService;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.api.email_service.repositories.emailServer.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailSESService implements EmailSenderGateway {

    @Autowired
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public EmailSESService(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {


        SendEmailRequest emailRequest = new SendEmailRequest()
                .withSource("fa34silva@gmail.com")
                .withDestination(new Destination().withCcAddresses())
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        try {

            this.amazonSimpleEmailService.sendEmail(emailRequest);

        } catch (AmazonServiceException exception){

            throw new AmazonSimpleEmailServiceException("Failure !");

        }

    }

}
