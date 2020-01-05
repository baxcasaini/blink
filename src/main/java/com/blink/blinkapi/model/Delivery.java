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
public class Delivery   {
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

        public Delivery id(String id) {
            this.id = id;
            return this;
        }
}
