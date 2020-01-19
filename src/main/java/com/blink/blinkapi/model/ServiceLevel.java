package com.blink.blinkapi.model;

import java.util.List;

import org.springframework.validation.annotation.Validated;


@Validated
public class ServiceLevel   {

	private ServiceLevelType type;
	  
	private List<TimeSlot> timeSlot;
		
	private String note;

	
	public ServiceLevelType getType() {
		return type;
	}

	public void setType(ServiceLevelType type) {
		this.type = type;
	}

	public List<TimeSlot> getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(List<TimeSlot> timeSlot) {
		this.timeSlot = timeSlot;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

	

}
