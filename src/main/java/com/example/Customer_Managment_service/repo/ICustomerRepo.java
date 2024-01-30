package com.example.Customer_Managment_service.repo;

import com.example.Customer_Managment_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepo extends JpaRepository<Customer,String> {
    List<Customer> findByFirstName(String name);

    List<Customer> findByEmail(String email);

    List<Customer> findByCity(String city);

    List<Customer> findByPhone(String phone);
}
