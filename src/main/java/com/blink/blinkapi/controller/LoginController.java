package com.blink.blinkapi.controller;

import com.blink.blinkapi.model.login.Account;
import com.blink.blinkapi.repository.login.AccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {

    private final AccountRepository accountRepository;

    public LoginController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping
    public String login(@RequestBody Account account) {
        account = accountRepository.save(account);
        return "ok";
    }
}