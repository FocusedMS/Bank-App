package com.bankingmanagementsystem.dto.mapper;

import com.bankingmanagementsystem.dto.AccountDto;
import com.bankingmanagementsystem.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){  // map AccountDto to Account
        Account account = new Account();
        if (accountDto.getId() != null) {
            account.setId(accountDto.getId());
        }
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setEmail(accountDto.getEmail());
        account.setMobileNumber(accountDto.getMobileNumber());
        // Set default values for system-generated fields
        account.setBalance(0.0);
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){  // map Account to AccountDto
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountHolderName(account.getAccountHolderName());
        accountDto.setEmail(account.getEmail());
        accountDto.setMobileNumber(account.getMobileNumber());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }
}
