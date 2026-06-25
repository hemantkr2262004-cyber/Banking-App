package com.example.Banking_App.controller;


import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class Accountcontroller {
    private AccountService accountService;

    public Accountcontroller(AccountService accountService){
        this.accountService=accountService;
    }
    // Add Account Rest API
    @PostMapping
    public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED );
    }
}
