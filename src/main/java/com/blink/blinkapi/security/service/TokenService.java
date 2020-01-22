package com.blink.blinkapi.security.service;


public interface TokenService {

    String getToken(String username, String password);
}
