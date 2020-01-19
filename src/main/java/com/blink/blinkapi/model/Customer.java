package com.blink.blinkapi.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Delivery
 */
@Validated
public class Customer{
  @JsonProperty("id")
  private String id = null;

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

  @JsonProperty("vatNumber")
  private String vatNumber = null;
}
