package com.blink.blinkapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

public class TestClassAuth {
	@Autowired
	private TestRestTemplate restTemplate;
	 
	@Test
	public void givenMemUsers_whenGetPingWithValidUser_thenOk() {
	    ResponseEntity<String> result 
	      = makeRestCallToGetPing("memuser", "pass");
	 
	    assertEquals(200, result.getStatusCodeValue());
	    assertEquals("OK", result.getBody());
	    
	}
	 
	@Test
	public void givenExternalUsers_whenGetPingWithValidUser_thenOK() {
	    ResponseEntity<String> result 
	      = makeRestCallToGetPing("externaluser", "pass");
	 
	    assertEquals(200, result.getStatusCodeValue());
	    assertEquals("OK", result.getBody());
	    
	}
	 
	@Test
	public void givenAuthProviders_whenGetPingWithNoCred_then401() {
	    ResponseEntity<String> result = makeRestCallToGetPing();
	 
	    assertEquals(401, result.getStatusCodeValue());
	    
	}
	 
	@Test
	public void givenAuthProviders_whenGetPingWithBadCred_then401() {
	    ResponseEntity<String> result 
	      = makeRestCallToGetPing("user", "bad_password");
	 
	    assertEquals(401, result.getStatusCodeValue());
	}
	 
	private ResponseEntity<String> makeRestCallToGetPing(String username, String password) {
	    return restTemplate.withBasicAuth(username, password)
	      .getForEntity("/api/ping", String.class, Collections.emptyMap());
	}
	 
	private ResponseEntity<String> makeRestCallToGetPing() {
	    return restTemplate
	      .getForEntity("/api/ping", String.class, Collections.emptyMap());
	}
}
