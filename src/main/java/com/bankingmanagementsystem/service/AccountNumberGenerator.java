package com.bankingmanagementsystem.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountNumberGenerator {
    
    private static final String BANK_CODE = "BANK"; 
    
    public String generateAccountNumber() {
    
        StringBuilder accountNumber = new StringBuilder(BANK_CODE);
        
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            accountNumber.append(random.nextInt(10));
        }
        
        return accountNumber.toString();
    }
} 
