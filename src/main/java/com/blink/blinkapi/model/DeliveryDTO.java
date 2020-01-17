package com.blink.blinkapi.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Slf4j
@Document(collection = "delivery")
public class DeliveryDTO {
	@Id
	private String id;
	private DeliveryStatus status;
	private Customer customer;
	private Receiver receiver;
	private List<Parcel> packages;
	private Date createdAt;
	private Date lastUpdateAt;

	private Receiver pickUpDate = null;
	private Receiver pickUpHourFrom = null;
	private Receiver pickUpHourTo = null;

	private Receiver deliveryDate = null;
	private Receiver deliveryHourFrom = null;
	private Receiver deliveryHourTo = null;

	private Receiver deliveryNote = null;

	public DeliveryDTO(Customer customer, Receiver receiver, List<Parcel> packages) {
		super();
		this.status = DeliveryStatus.created;
		this.customer = customer;
		this.receiver = receiver;
		this.packages = packages;
		this.createdAt = new Date();
		this.lastUpdateAt = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastUpdateAt() {
		return lastUpdateAt;
	}

	public void setLastUpdateAt(Date lastUpdateAt) {
		this.lastUpdateAt = lastUpdateAt;
	}

	public Receiver getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Receiver pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Receiver getPickUpHourFrom() {
		return pickUpHourFrom;
	}

	public void setPickUpHourFrom(Receiver pickUpHourFrom) {
		this.pickUpHourFrom = pickUpHourFrom;
	}

	public Receiver getPickUpHourTo() {
		return pickUpHourTo;
	}

	public void setPickUpHourTo(Receiver pickUpHourTo) {
		this.pickUpHourTo = pickUpHourTo;
	}

	public Receiver getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Receiver deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Receiver getDeliveryHourFrom() {
		return deliveryHourFrom;
	}

	public void setDeliveryHourFrom(Receiver deliveryHourFrom) {
		this.deliveryHourFrom = deliveryHourFrom;
	}

	public Receiver getDeliveryHourTo() {
		return deliveryHourTo;
	}

	public void setDeliveryHourTo(Receiver deliveryHourTo) {
		this.deliveryHourTo = deliveryHourTo;
	}

	public Receiver getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(Receiver deliveryNote) {
		this.deliveryNote = deliveryNote;
	}
	
	
}
