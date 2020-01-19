package com.blink.blinkapi.model;

import java.util.Objects;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Parcel
 */
@Data
@Validated
public class Parcel   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("price")
  private String price = null;

  @JsonProperty("weight")
  private Integer weight = null;

  @JsonProperty("dimension")
  private Dimension dimension = null;
  
  @JsonProperty("notStackable")
  private boolean notStackable = false;

  @JsonProperty("fragile")
  private boolean fragile = false;
  
  @JsonProperty("notFlippable")
  private boolean notFlippable = false;
  
  @JsonProperty("note")
  private String note = null;

}
