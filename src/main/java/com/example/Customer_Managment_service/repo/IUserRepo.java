package com.example.Customer_Managment_service.repo;

import com.example.Customer_Managment_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
