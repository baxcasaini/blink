package com.blink.blinkapi.config.login;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	Map<String, String> userList;
	
	
	
    @Override
    public Authentication authenticate(Authentication auth) 
      throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials()
            .toString();
       for(Entry<String, String> x: userList.entrySet()) {
    	   
      //Controlla nella mappa degli utenti se è abilitato per l'autenticazione
        if (x.getKey().equals(username) && x.getValue().equals(password)) {
            return new UsernamePasswordAuthenticationToken
              (username, password, Collections.emptyList());
        } 
                   
       }
       throw new    BadCredentialsException("External system authentication failed");
    }
 
    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}