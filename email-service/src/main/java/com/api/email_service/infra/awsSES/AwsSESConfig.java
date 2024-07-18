package com.api.email_service.infra.awsSES;


import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSESConfig {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService(){

        return AmazonSimpleEmailServiceClientBuilder.standard().withRegion("sa-east-1").build();

    }

}
