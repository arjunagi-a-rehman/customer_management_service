package com.example.Customer_Managment_service.model;

import jakarta.persistence.*;
import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
}
