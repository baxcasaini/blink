package com.blink.blinkapi.model.login;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Account {

    @Id
    @GeneratedValue
    private String id;
    private String username;
    private String password;

    public Account(){}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}