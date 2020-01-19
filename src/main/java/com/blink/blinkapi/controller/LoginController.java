//package com.blink.blinkapi.controller;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.blink.blinkapi.model.Customer;
//import com.blink.blinkapi.model.login.Account;
//import com.blink.blinkapi.repository.login.CustomerRepository;
//
//@RestController
//@RequestMapping("/login")
//@CrossOrigin(origins = "http://localhost:8080")
//public class LoginController {
//
//    private final CustomerRepository customerRepository;
//    @Autowired
//    private Map<String, String> userListAuth;
//
//    public LoginController(CustomerRepository accountRepository) {
//        this.customerRepository = accountRepository;
//    }
//
//    @PostMapping
//    public String login(@RequestBody Customer account) {
//    	//QUESTO METODO AGGIUNGE UTENTI CHE POSSONO AUTENTICARSI
//    	//userListAuth.put(account.getEmail(), account.getBlinkCoins());
//    	Account a = new Account(account.getEmail(), account.getBlinkCoins());
//        account = customerRepository.save(a);
//        return "ok";
//    }
//
//    @DeleteMapping("/deleteAllUsers")
//    public void deleteAll() {
//        customerRepository.deleteAll();
//    }
//    @GetMapping("/api/ping")
//    public String getPing() {
//        return "OK";
//    }
//}