package com.bankingmanagementsystem.dto.mapper;

import com.bankingmanagementsystem.dto.AccountDto;
import com.bankingmanagementsystem.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account();
                if (accountDto.getId() != null) {
                    account.setId(accountDto.getId());
                }
                account.setAccountNumber(accountDto.getAccountNumber());
                account.setAccountHolderName(accountDto.getAccountHolderName());
                account.setEmail(accountDto.getEmail());
                account.setMobileNumber(accountDto.getMobileNumber());
                account.setBalance(accountDto.getBalance());
                return account;
    }

    public static AccountDto mapToAccountDto(Account account){
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
