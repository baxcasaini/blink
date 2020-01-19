package com.blink.blinkapi.model.login;

public class Account {

    private String id;
    private String username;
    private String password;
    private String clienCode;
    private Integer clientAmount;

    public Account(){}

    public Account(String username, String password, String clientCode, Integer clientAmount) {
        this.username = username;
        this.password = password;
        this.clienCode = clientCode;
        this.clientAmount = clientAmount;
    }
}