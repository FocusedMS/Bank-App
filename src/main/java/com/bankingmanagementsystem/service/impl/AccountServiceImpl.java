package com.bankingmanagementsystem.service.impl;

import com.bankingmanagementsystem.dto.AccountDto;
import com.bankingmanagementsystem.dto.mapper.AccountMapper;
import com.bankingmanagementsystem.entity.Account;
import com.bankingmanagementsystem.exception.AccountAlreadyExistsException;
import com.bankingmanagementsystem.exception.ResourceNotFoundException;
import com.bankingmanagementsystem.repository.AccountRepository;
import com.bankingmanagementsystem.service.AccountNumberGenerator;
import com.bankingmanagementsystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        // Validate required fields
        if (accountDto.getAccountHolderName() == null || accountDto.getAccountHolderName().trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name is required");
        }
        
        if (accountDto.getEmail() == null || accountDto.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        
        if (accountDto.getMobileNumber() == null || accountDto.getMobileNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Mobile number is required");
        }
        
        // Validate mobile number format
        if (!accountDto.getMobileNumber().matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException("Mobile number must be exactly 10 digits");
        }
        
        // Check for existing email
        if (accountRepository.existsByEmail(accountDto.getEmail())) {
            throw new AccountAlreadyExistsException("Account with email " + accountDto.getEmail() + " already exists");
        }
        
        // Check for existing mobile number
        if (accountRepository.existsByMobileNumber(accountDto.getMobileNumber())) {
            throw new AccountAlreadyExistsException("Account with mobile number " + accountDto.getMobileNumber() + " already exists");
        }

        // Generate account number
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

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AccountMapper::mapToAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));

        // Update fields if they are not null
        if (accountDto.getAccountHolderName() != null) {
            existingAccount.setAccountHolderName(accountDto.getAccountHolderName());
        }
        if (accountDto.getEmail() != null) {
            existingAccount.setEmail(accountDto.getEmail());
        }
        if (accountDto.getMobileNumber() != null) {
            existingAccount.setMobileNumber(accountDto.getMobileNumber());
        }

        Account updatedAccount = accountRepository.save(existingAccount);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException("Account not found with id: " + id);
        }
        accountRepository.deleteById(id);
    }

    @Override
    public double checkBalance(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
        return account.getBalance();
    }
}
