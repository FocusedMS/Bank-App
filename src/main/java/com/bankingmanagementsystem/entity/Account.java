package com.bankingmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// JPA annotations
@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Column(name = "account_holder_name")
    private String accountHolderName;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "mobile_number", unique = true)
    private String mobileNumber;
    
    private double balance;
}
