package com.blink.blinkapi.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * value in cm
 */
@Validated
public class Dimension   {
  @JsonProperty("height")
  private Integer height = null;

  @JsonProperty("width")
  private Integer width = null;

  @JsonProperty("depth")
  private Integer depth = null;

}
