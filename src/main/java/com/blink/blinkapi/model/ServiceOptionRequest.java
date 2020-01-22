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
@Validated
public class ServiceOptionRequest {
        

        @JsonProperty("customer")
        private String customer = null;

        @JsonProperty("receiver")
        private Receiver receiver = null;

        @JsonProperty("packages")
        @Valid
        private List<Parcel> packages = null;

		public String getCustomer() {
			return customer;
		}

		public void setCustomer(String customer) {
			this.customer = customer;
		}

		public Receiver getReceiver() {
			return receiver;
		}

		public void setReceiver(Receiver receiver) {
			this.receiver = receiver;
		}

		public List<Parcel> getPackages() {
			return packages;
		}

		public void setPackages(List<Parcel> packages) {
			this.packages = packages;
		}

        
        
        

}
