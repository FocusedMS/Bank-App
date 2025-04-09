package com.bankingmanagementsystem.service.impl;

import com.bankingmanagementsystem.dto.AccountDto;
import com.bankingmanagementsystem.dto.mapper.AccountMapper;
import com.bankingmanagementsystem.entity.Account;
import com.bankingmanagementsystem.exception.AccountAlreadyExistsException;
import com.bankingmanagementsystem.repository.AccountRepository;
import com.bankingmanagementsystem.service.AccountNumberGenerator;
import com.bankingmanagementsystem.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private AccountNumberGenerator accountNumberGenerator;

    public AccountServiceImpl(AccountRepository accountRepository, AccountNumberGenerator accountNumberGenerator) {
        this.accountRepository = accountRepository;
        this.accountNumberGenerator = accountNumberGenerator;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        // checking if account with the same email already exists
        if (accountDto.getEmail() != null && accountRepository.existsByEmail(accountDto.getEmail())) {
            throw new AccountAlreadyExistsException("Account with email " + accountDto.getEmail() + " already exists");
        }
        
        // checking if account with the same mobile number already exists
        if (accountDto.getMobileNumber() != null && accountRepository.existsByMobileNumber(accountDto.getMobileNumber())) {
            throw new AccountAlreadyExistsException("Account with mobile number " + accountDto.getMobileNumber() + " already exists");
        }
        
        // Generate a unique account number
        String accountNumber = accountNumberGenerator.generateAccountNumber();
        
        // Convert DTO to Entity
        Account account = AccountMapper.mapToAccount(accountDto);
        
        // Set the generated account number
        account.setAccountNumber(accountNumber);
        
        // Always set balance to zero for new accounts
        account.setBalance(0.0);
        
        // Save to database
        Account savedAccount = accountRepository.save(account);
        
        // Convert back to DTO and return
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
