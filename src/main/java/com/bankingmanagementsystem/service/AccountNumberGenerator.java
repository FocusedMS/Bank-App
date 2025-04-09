package com.bankingmanagementsystem.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountNumberGenerator {
    
    private static final String BANK_CODE = "BANK"; // bank code
    private static final int ACCOUNT_NUMBER_LENGTH = 10;
    
    public String generateAccountNumber() {
        // generates a random account number with the specified length
        StringBuilder accountNumber = new StringBuilder(BANK_CODE);
        
        // 6-digit number code
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            accountNumber.append(random.nextInt(10));
        }
        
        return accountNumber.toString();
    }
} 