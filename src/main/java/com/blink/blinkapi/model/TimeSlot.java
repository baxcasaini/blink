package com.blink.blinkapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * value in cm
 */
@Validated
public class TimeSlot {
	private DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm");

	@JsonProperty("date")
	private String date = null;

	@JsonProperty("hourFrom")
	private String hourFrom = null;

	@JsonProperty("hourTo")
	private String hourTo = null;
	
	@JsonProperty("cost")
	private double cost;

	@JsonProperty("note")
	private String note = null;

	public String getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date.format(data);
	}

	public String getHourFrom() {
		return hourFrom;
	}

	public void setHourFrom(LocalDateTime hourFrom) {
		this.hourFrom = hourFrom.format(time);
	}

	public String getHourTo() {
		return hourTo;
	}

	public void setHourTo(LocalDateTime hourTo) {
		this.hourTo = hourTo.format(time);
	}
	

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
