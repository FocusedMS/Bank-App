package com.bankingmanagementsystem.service;

import com.bankingmanagementsystem.dto.AccountDto;
import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Long id);
    List<AccountDto> getAllAccounts();
    AccountDto updateAccount(Long id, AccountDto account);
    void deleteAccount(Long id);
    double checkBalance(Long id);
}
