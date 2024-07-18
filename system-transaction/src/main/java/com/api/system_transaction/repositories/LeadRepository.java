package com.api.system_transaction.repositories;

import com.api.system_transaction.domain.lead.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {
}
