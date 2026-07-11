package com.example.Banking_App.controller;


import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.service.AccountService;
import org.aspectj.apache.bcel.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    // Get Account Rest API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
  //Deposite rest API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto= accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }
//    withdraw rest API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdraw(@PathVariable Long id ,  @RequestBody Map<String,Double>request){
    Double amount = request.get("amount");
    AccountDto accountDto = accountService.withdraw(id,amount);
    return ResponseEntity.ok(accountDto);
    }
}









