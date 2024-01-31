package com.example.Customer_Managment_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter@Setter@ToString
@Entity
@AllArgsConstructor
public class Customer extends BaseEntity{
    @Id
    private String uuid;
    private String firstName;
    private String lastName;
    private String street;
    private String address;
    private String city;
    private String state;
    private String email;
    private String phone;
    public  Customer(){
        this.uuid= UUID.randomUUID().toString();
    }
}
