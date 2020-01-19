package com.blink.blinkapi.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

@Validated
public class Account {

    private String id;

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("clientCode")
    private String clientCode;
    @JsonProperty("clientAmount")
    private Integer clientAmount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public Integer getClientAmount() {
        return clientAmount;
    }

    public void setClientAmount(Integer clientAmount) {
        this.clientAmount = clientAmount;
    }
}