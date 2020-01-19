package com.blink.blinkapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Address
 */
@Validated
public class Service {

    @JsonProperty("onehour")
    private String onehour = null;

    @JsonProperty("twohour")
    private String twohour = null;

    @JsonProperty("deliveryNoteStandard")
    private String deliveryNoteStandard = null;

    @JsonProperty("deliveryNoteUrgent")
    private String deliveryNoteUrgent = null;

    @JsonProperty("twoHourInterval")
    private String twoHourInterval = null;

    @JsonProperty("fourHourInterval")
    private String fourHourInterval = null;

    @JsonProperty("deliveryNoteInterval")
    private String deliveryNoteInterval = null;

    @JsonProperty("standardDeliveryTime")
    private String standardDeliveryTime = null;

}
