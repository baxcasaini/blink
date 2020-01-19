package com.blink.blinkapi.model;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Delivery
 */
@Validated
public class Delivery {
        @Id
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

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public Customer getCustomer() {
                return customer;
        }

        public void setCustomer(Customer customer) {
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

        public String getPickUpDate() {
                return pickUpDate;
        }

        public void setPickUpDate(String pickUpDate) {
                this.pickUpDate = pickUpDate;
        }

        public String getPickUpHourFrom() {
                return pickUpHourFrom;
        }

        public void setPickUpHourFrom(String pickUpHourFrom) {
                this.pickUpHourFrom = pickUpHourFrom;
        }

        public String getPickUpHourTo() {
                return pickUpHourTo;
        }

        public void setPickUpHourTo(String pickUpHourTo) {
                this.pickUpHourTo = pickUpHourTo;
        }

        public String getDeliveryDate() {
                return deliveryDate;
        }

        public void setDeliveryDate(String deliveryDate) {
                this.deliveryDate = deliveryDate;
        }

        public String getDeliveryHourFrom() {
                return deliveryHourFrom;
        }

        public void setDeliveryHourFrom(String deliveryHourFrom) {
                this.deliveryHourFrom = deliveryHourFrom;
        }

        public String getDeliveryHourTo() {
                return deliveryHourTo;
        }

        public void setDeliveryHourTo(String deliveryHourTo) {
                this.deliveryHourTo = deliveryHourTo;
        }

        public String getDeliveryNote() {
                return deliveryNote;
        }

        public void setDeliveryNote(String deliveryNote) {
                this.deliveryNote = deliveryNote;
        }

        public String getPaymentCode() {
                return paymentCode;
        }

        public void setPaymentCode(String paymentCode) {
                this.paymentCode = paymentCode;
        }
}
