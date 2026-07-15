package com.example.Banking_App.service.implemation;

import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.dto.mapper.Accountmapper;
import com.example.Banking_App.entity.Account;
import com.example.Banking_App.repository.AccountRepository;
import com.example.Banking_App.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = Accountmapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return Accountmapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        return Accountmapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account saveAccount = accountRepository.save(account);
        return Accountmapper.mapToAccountDto(saveAccount);

    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

        if (account.getBalance() < amount) {
throw new RuntimeException ("Insuficient Balance");
        }
        double total= account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount= accountRepository.save(account);
        return Accountmapper.mapToAccountDto(savedAccount);
    }
}