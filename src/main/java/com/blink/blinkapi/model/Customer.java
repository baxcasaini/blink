package com.blink.blinkapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Delivery
 */
@Document(collection = "customer")
public class Customer {
	@Id
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("password")
	private String password = null;

	@JsonProperty("type")
	private String type = null;

	@JsonProperty("address")
	private Address address = null;

	@JsonProperty("billingAddress")
	private Address billingAddress = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("lastname")
	private String lastname = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("phoneNumber")
	private String phoneNumber = null;

	@JsonProperty("fiscalcode")
	private String fiscalcode = null;

	@JsonProperty("businessName")
	private String businessName = null;

	// P.iva
	@JsonProperty("vatNumber")
	private String vatNumber = null;

	@JsonProperty("note")
	private String note = null;

	@JsonProperty("blinkCoins")
	private double blinkCoins = 0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFiscalcode() {
		return fiscalcode;
	}

	public void setFiscalcode(String fiscalcode) {
		this.fiscalcode = fiscalcode;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getBlinkCoins() {
		return blinkCoins;
	}

	public void setBlinkCoins(double blinkCoins) {
		this.blinkCoins = blinkCoins;
	}

	@Override
	public String toString() {
		return "{\n\"id\":\"" + id + "\",\n \"password\":\"" + password + "\",\n \"type\":\"" + type
				+ "\",\n \"address\":\"" + address + "\",\n \"billingAddress\":\"" + billingAddress
				+ "\",\n \"name\":\"" + name + "\",\n \"lastname\":\"" + lastname + "\",\n \"email\":\"" + email
				+ "\",\n \"phoneNumber\":\"" + phoneNumber + "\",\n \"fiscalcode\":\"" + fiscalcode
				+ "\",\n \"businessName\":\"" + businessName + "\",\n \"vatNumber\":\"" + vatNumber
				+ "\",\n \"note\":\"" + note + "\",\n \"blinkCoins\":\"" + blinkCoins + "\"\n}";
	}

	
	
	

}
