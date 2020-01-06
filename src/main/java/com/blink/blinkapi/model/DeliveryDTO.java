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
}
