package com.api.system_transaction.controller;


import com.api.system_transaction.DTOS.LeadDTO;
import com.api.system_transaction.domain.lead.Lead;
import com.api.system_transaction.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public ResponseEntity <Lead> createLead(@RequestBody LeadDTO leadDTO){

        Lead newLead = leadService.createLead(leadDTO);
        return new ResponseEntity<>(newLead , HttpStatus.CREATED);

    }

}
