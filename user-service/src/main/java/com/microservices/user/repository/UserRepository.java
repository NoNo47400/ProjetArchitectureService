package com.microservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}