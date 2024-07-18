package com.api.system_transaction.DTOS;

import com.api.system_transaction.domain.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.List;

public record UserDTO (
        String firstName,
        String lastName,
        String email,
        String phone,
        String document,
        Long productId
        )
{
}
