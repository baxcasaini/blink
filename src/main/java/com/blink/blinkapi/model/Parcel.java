package com.blink.blinkapi.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Parcel
 */
@Validated
public class Parcel   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("price")
  private String price = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    COMMON("COMMON"),
    
    FOOD("FOOD"),
    
    FRAGILE("FRAGILE");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("weight")
  private Integer weight = null;

  @JsonProperty("dimension")
  private Dimension dimension = null;

}
