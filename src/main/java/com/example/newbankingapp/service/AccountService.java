package com.example.newbankingapp.service;

import com.example.newbankingapp.entity.Account;
import com.example.newbankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).get();
    }

    public Account depositMoney(Long id, double amount) {
        Account account = accountRepository.findById(id).orElse(null);

        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            return accountRepository.save(account);
        }
        return null;
    }

    public Account withdrawMoney(Long id, double amount) {
        Account account = accountRepository.findById(id).orElse(null);

        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return accountRepository.save(account);
        }
        return null;
    }

    public Account calculateInterest(Account account, int months) {
        account.setBalance(account.getBalance() * 0.25);

        return accountRepository.save(account);
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }


    public Map<String, Boolean> deleteAccount(Long id) throws Exception {

        Account account = accountRepository.findById(id).orElseThrow(()-> new Exception("Account not found!"));

        accountRepository.delete(account);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
