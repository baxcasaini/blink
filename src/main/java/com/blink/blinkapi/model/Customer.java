package com.blink.blinkapi.model;

import java.util.Objects;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Delivery
 */
@Data
@Validated
public class Customer{
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("lastname")
  private String lastname = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;
}
