package com.example.Banking_App.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private String accountholderName;
    private double balance;
}
