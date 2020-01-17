package com.blink.blinkapi.controller;

import com.blink.blinkapi.model.login.Account;
import com.blink.blinkapi.repository.login.AccountRepository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {

    private final AccountRepository accountRepository;
    @Autowired
    private Map<String, String> userListAuth;

    public LoginController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping
    public String login(@RequestBody Account account) {
    	//QUESTO METODO AGGIUNGE UTENTI CHE POSSONO AUTENTICARSI
    	userListAuth.put(account.getUsername(), account.getPassword());
        account = accountRepository.save(account);
        return "ok";
    }

    @DeleteMapping("/deleteAllUsers")
    public void deleteAll() {
        accountRepository.deleteAll();
    }
    @GetMapping("/api/ping")
    public String getPing() {
        return "OK";
    }
}