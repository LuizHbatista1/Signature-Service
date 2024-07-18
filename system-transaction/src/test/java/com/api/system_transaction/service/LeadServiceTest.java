package com.api.system_transaction.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import com.api.email_service.service.emailService.EmailSESService;
import com.api.system_transaction.DTOS.LeadDTO;
import com.api.system_transaction.common.LeadConstants;
import com.api.system_transaction.domain.lead.Lead;
import com.api.system_transaction.repositories.LeadRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = LeadService.class)
public class LeadServiceTest {

    @Autowired
    private LeadService leadService;

    @MockBean
    private EmailSESService emailSESService;

    @MockBean
    private LeadRepository leadRepository;

    @Test
    public void createLead_WithValidDate_ReturnsLead(){

        LeadDTO leadDTO = LeadConstants.LEAD_DTO;
        Lead lead = new Lead(leadDTO);

        when(leadRepository.save(ArgumentMatchers.any(Lead.class))).thenReturn(lead);

        Lead sut = leadService.createLead(leadDTO);
        assertThat(sut).isEqualTo(lead);

    }

    @Test
    public void createLead_WithInvalidDate_ReturnLead(){

        LeadDTO leadDTO = LeadConstants.LEAD_DTO;
        Lead lead = new Lead(leadDTO);

        when(leadRepository.save(lead)).thenThrow(RuntimeException.class);

        assertThatThrownBy(()->leadService.createLead(leadDTO)).isInstanceOf(RuntimeException.class);

    }





}
