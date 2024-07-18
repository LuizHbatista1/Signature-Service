package com.api.system_transaction.repositories;

import com.api.system_transaction.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {
}
