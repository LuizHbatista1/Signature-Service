package com.api.system_transaction.service;

import com.api.email_service.service.emailService.EmailSESService;
import com.api.system_transaction.DTOS.LeadDTO;
import com.api.system_transaction.domain.lead.Lead;
import com.api.system_transaction.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    @Autowired
    private EmailSESService emailSESService;

    @Autowired
    private LeadRepository leadRepository;

    public Lead createLead(LeadDTO leadDTO){

        String subject = "Thank for contact !";
        String body = "we will return soon";
        Lead newLead = new Lead(leadDTO);
        newLead.setName(newLead.getName());
        newLead.setMessage(newLead.getMessage());
        newLead.setEmail(newLead.getMessage());
        emailSESService.sendEmail(newLead.getEmail(), subject , body);
        this.saveLead(newLead);
        return newLead;

    }

    public void saveLead(Lead lead){

        this.leadRepository.save(lead);

    }




}
