package com.example.newbankingapp.controller;


import com.example.newbankingapp.entity.Account;
import com.example.newbankingapp.service.AccountService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public Account createAccount(@Validated @RequestBody Account account){
        return accountService.createAccount(account);
    }

//    @GetMapping("/accountId/{id}")
//    public ResponseEntity<Account> getAccountById(@PathVariable(value="id") Long id) throws Exception {
//
//        return accountService.getAccountById(id);
//    }

    @PostMapping("/deposit/{id}")
    public Account deposit(@PathVariable Long id, @RequestParam double amount) {
        return accountService.depositMoney(id, amount);
    }

    @PostMapping("/withdraw/{id}")
    public Account withdraw(@PathVariable Long id, @RequestParam double amount) {
        return accountService.withdrawMoney(id, amount);
    }

    @GetMapping("/account")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteAccount(@PathVariable(value = "id") Long id) throws Exception
    {
        return accountService.deleteAccount(id);
    }



}
