package com.blink.blinkapi.security.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blink.blinkapi.security.exception.UserNotFoundException;
import com.blink.blinkapi.security.model.User;
import com.blink.blinkapi.security.model.UserAuthentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Service
public class JsonWebTokenAuthenticationService implements TokenAuthenticationService {

    @Value("${security.token.secret.key}")
    private String secretKey;
    
    
    private  final String URL = "http://localhost:8081/api/auth/";
    private  String token = "";
 
    @Override
    public Authentication authenticate(final HttpServletRequest request){
        token = request.getHeader("Authorization");
        final Jws<Claims> tokenData = parseToken(token);
        if (tokenData != null && checkIsValid(tokenData)) {
            User user = getUserFromToken(tokenData);
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;
    }

    private Jws<Claims> parseToken(final String token) {
        if (token != null) {
            try {
                return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token.replace("Bearer ",""));
            } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
                    | SignatureException | IllegalArgumentException e) {
                return null;
            }
        }
        return null;
    }
    private boolean checkIsValid (final Jws<Claims> tokenData) {
    	Long mi = (Long) tokenData.getBody().get("token_expiration_date");
    	LocalDateTime tokenExpiration = LocalDateTime.ofInstant(Instant.ofEpochMilli(mi),ZoneId.systemDefault());
    	LocalDateTime now = LocalDateTime.now();
    	return now.isBefore(tokenExpiration);
    }
    private User getUserFromToken(final Jws<Claims> tokenData) {
    	
        try {
        	RestTemplate rt = new RestTemplate();
        	return rt.getForEntity(URL + token.replace("Bearer ",""), User.class).getBody();
            //return (User) 
        } catch (UsernameNotFoundException e) {
            throw new UserNotFoundException("User "
                    + tokenData.getBody().get("username").toString() + " not found");
        }
    }
}
