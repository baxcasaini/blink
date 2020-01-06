package com.blink.blinkapi.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Delivery
 */
@Data
@Validated
public class Delivery {
        @Id
        @GeneratedValue
        @JsonProperty("id")
        private String id = null;

        @JsonProperty("customer")
        private Customer customer = null;

        @JsonProperty("receiver")
        private Receiver receiver = null;

        @JsonProperty("packages")
        @Valid
        private List<Parcel> packages = null;

        @JsonProperty("pickUpDate")
        private String pickUpDate = null;
        @JsonProperty("pickUpHourFrom")
        private String pickUpHourFrom = null;
        @JsonProperty("pickUpHourTo")
        private String pickUpHourTo = null;

        @JsonProperty("deliveryDate")
        private String deliveryDate = null;
        @JsonProperty("deliveryHourFrom")
        private String deliveryHourFrom = null;
        @JsonProperty("deliveryHourTo")
        private String deliveryHourTo = null;

        @JsonProperty("deliveryNote")
        private String deliveryNote = null;

        @JsonProperty("paymentCode")
        private String paymentCode = null;

}
