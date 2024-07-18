package com.api.system_transaction.repositories;

import com.api.system_transaction.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
