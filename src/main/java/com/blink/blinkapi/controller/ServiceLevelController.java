package com.blink.blinkapi.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blink.blinkapi.model.ServiceLevel;
import com.blink.blinkapi.model.ServiceLevelRequest;
import com.blink.blinkapi.model.ServiceLevelType;
import com.blink.blinkapi.model.TimeSlot;

@RestController
@RequestMapping("/servicelevel")
//@CrossOrigin(origins = "http://blink-s3.s3-website.eu-west-3.amazonaws.com")
@CrossOrigin(origins = "http://localhost:8080")
public class ServiceLevelController {

	//TODO ALE preventivo spedizione e SERVICE LEVEL
	@PostMapping
	public List<ServiceLevel> create(@RequestBody ServiceLevelRequest slRequest) {
		//TODO ALE CHECK INFORMATION
		//FA CAGARE MA PER IL MOMENTO FORNISCE UN MOCK SENSATO IN RISPOSTA
		List<ServiceLevel> listSL = new ArrayList<>();
		ServiceLevel sl1 = new ServiceLevel();
		sl1.setType(ServiceLevelType.urgent);
			List<TimeSlot> timeSlotSL1 = new ArrayList<>();
				TimeSlot t1SL1 = new TimeSlot();
				t1SL1.setDate(LocalDate.now());
				t1SL1.setHourFrom(LocalDateTime.now().plus(1,ChronoUnit.HOURS));
				t1SL1.setHourTo(LocalDateTime.now().plus(2,ChronoUnit.HOURS));
				t1SL1.setCost(20.99);
				TimeSlot t2SL1 = new TimeSlot();
				t2SL1.setDate(LocalDate.now());
				t2SL1.setHourFrom(LocalDateTime.now().plus(2,ChronoUnit.HOURS));
				t2SL1.setHourTo(LocalDateTime.now().plus(3,ChronoUnit.HOURS));
				t2SL1.setCost(25.99);
			timeSlotSL1.add(t1SL1);
			timeSlotSL1.add(t2SL1);
		sl1.setTimeSlot(timeSlotSL1);
		
		
		ServiceLevel sl2 = new ServiceLevel();
		sl2.setType(ServiceLevelType.timeSlot);
			List<TimeSlot> timeSlotSL2 = new ArrayList<>();
				TimeSlot t1SL2 = new TimeSlot();
				t1SL2.setDate(LocalDate.now().plus(1,ChronoUnit.DAYS));
				t1SL2.setHourFrom(LocalDateTime.now().plus(1,ChronoUnit.DAYS).plus(2,ChronoUnit.HOURS));
				t1SL2.setHourTo(LocalDateTime.now().plus(1,ChronoUnit.DAYS).plus(4,ChronoUnit.HOURS));
				t1SL2.setCost(8.99);
				TimeSlot t2SL2 = new TimeSlot();
				t2SL2.setDate(LocalDate.now().plus(1,ChronoUnit.DAYS));
				t2SL2.setHourFrom(LocalDateTime.now().plus(1,ChronoUnit.DAYS).plus(4,ChronoUnit.HOURS));
				t2SL2.setHourTo(LocalDateTime.now().plus(1,ChronoUnit.DAYS).plus(6,ChronoUnit.HOURS));
				t2SL2.setCost(9.99);
				timeSlotSL2.add(t1SL2);
				timeSlotSL2.add(t2SL2);
		sl2.setTimeSlot(timeSlotSL2);
		
		
		ServiceLevel sl3 = new ServiceLevel();
		sl3.setType(ServiceLevelType.Standard);
			List<TimeSlot> timeSlotSL3 = new ArrayList<>();
				TimeSlot t1SL3 = new TimeSlot();
				t1SL3.setDate(LocalDate.now().plus(1,ChronoUnit.DAYS));
				t1SL3.setHourFrom(LocalDateTime.now().plus(1,ChronoUnit.DAYS).plus(2,ChronoUnit.HOURS));
				t1SL3.setHourTo(LocalDateTime.now().plus(1,ChronoUnit.DAYS).plus(10,ChronoUnit.HOURS));
				t1SL3.setCost(3.99);
				timeSlotSL3.add(t1SL3);
		sl3.setTimeSlot(timeSlotSL3);
		listSL.add(sl1);
		listSL.add(sl2);
		listSL.add(sl3);
		return listSL;
	}

	
}
