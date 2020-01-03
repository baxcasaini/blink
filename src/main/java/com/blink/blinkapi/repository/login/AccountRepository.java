package com.blink.blinkapi.repository.login;

import com.blink.blinkapi.model.login.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

    public Account findByUsername(String username);

}