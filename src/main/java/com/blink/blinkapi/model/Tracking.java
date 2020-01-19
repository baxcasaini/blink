package com.blink.blinkapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.Objects;

/**
 * value in cm
 */
@Validated
public class Tracking {
	@JsonProperty("idTracking")
	private String idTracking = null;

	@JsonProperty("idDelivery")
	private String idDelivery = null;

	@JsonProperty("idCourrier")
	private String idCourrier = null;

	@JsonProperty("status")
	private DeliveryStatus status = null;

	@JsonProperty("lastStatusUpdateAt")
	private Date lastStatusUpdateAt = null;
}
