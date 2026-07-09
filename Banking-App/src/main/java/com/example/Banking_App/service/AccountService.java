package com.example.Banking_App.service;

import com.example.Banking_App.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount (AccountDto accountDto );
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, Double amount);
    AccountDto  withdraw(Long id , Double amount);


}
