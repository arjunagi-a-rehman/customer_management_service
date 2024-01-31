package com.example.Customer_Managment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImp")
public class CustomerManagmentServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerManagmentServiceApplication.class, args);
	}
}
