package com.api.system_transaction.DTOS;

import com.api.system_transaction.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;

public record TransactionDTO (
        Long sender,
        String nameOfCard,
        String numberOfCard,
        Integer codeSecurity,
        String validate,
        Double balance)
{
}
