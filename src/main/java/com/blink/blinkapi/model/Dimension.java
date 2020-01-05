package com.blink.blinkapi.model;

import java.util.Objects;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * value in cm
 */
@Data
@Validated
public class Dimension   {
  @JsonProperty("height")
  private Integer height = null;

  @JsonProperty("width")
  private Integer width = null;

  @JsonProperty("depth")
  private Integer depth = null;

}
