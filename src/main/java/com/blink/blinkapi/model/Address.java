package com.blink.blinkapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * Address
 */
@Data
@Validated
public class Address   {
  @JsonProperty("road")
  private String road = null;

  @JsonProperty("number")
  private String number = null;

  @JsonProperty("normalized")
  private Boolean normalized = false;

  @JsonProperty("province")
  private String province = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("zipcode")
  private String zipcode = null;
}
