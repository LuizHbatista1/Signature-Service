package com.api.system_transaction.common;

import com.api.system_transaction.DTOS.LeadDTO;
import com.api.system_transaction.domain.lead.Lead;

public class LeadConstants {

    public final static LeadDTO LEAD_DTO = new LeadDTO("Test","Test","teste@gmail.com");
    public final static Lead LEAD = new Lead(LEAD_DTO);
    public final static LeadDTO INVALID_LEAD = new LeadDTO("","","");

}
