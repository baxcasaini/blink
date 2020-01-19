package com.blink.blinkapi.model.login;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.bson.internal.Base64;


public class Account {

    @Id
    @GeneratedValue
    private String id;
    private String codiceAccount;
    private String email;
    private int blinkCoins;
    

    public Account(){}

    public Account(String email, int blinkCoins) {
    	this.email = email;
    	//valutare di accorciare la stringa codiceAccount
    	this.codiceAccount =Long.toString(UUID.randomUUID().getMostSignificantBits());
    	//DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
    	this.blinkCoins = blinkCoins;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodiceAccount() {
		return codiceAccount;
	}

	public void setCodiceAccount(String codiceAccount) {
		this.codiceAccount = codiceAccount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBlinkCoins() {
		return blinkCoins;
	}

	public void setBlinkCoins(int blinkCoins) {
		this.blinkCoins = blinkCoins;
	}

	
}