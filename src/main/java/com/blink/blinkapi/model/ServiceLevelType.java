package com.blink.blinkapi.model;

public enum ServiceLevelType {
	urgent("URGENT"), 
	timeSlot("TIMESLOT"),
	Standard("STANDARD");

	public String value;

	ServiceLevelType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public ServiceLevelType fromValue(String value) {
		for(ServiceLevelType v : ServiceLevelType.values()) {
			if(v.getValue().equals(value)) {
				return v;
			}
		}
		throw new IllegalArgumentException("Value NOT found");
	}

}
