package com.blink.blinkapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tracking")
public class TrackingDTO {
	@Id
	private String idTracking;
	private String idCourrier = null;
	private DeliveryStatus status = null;
	private Date lastStatusUpdateAt = null;

}
