package com.blink.blinkapi.model;

public enum ServiceOptionType {
	urgent("URGENT"), 
	timeSlot("TIMESLOT"),
	Standard("STANDARD");

	public String value;

	ServiceOptionType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public ServiceOptionType fromValue(String value) {
		for(ServiceOptionType v : ServiceOptionType.values()) {
			if(v.getValue().equals(value)) {
				return v;
			}
		}
		throw new IllegalArgumentException("Value NOT found");
	}

}
