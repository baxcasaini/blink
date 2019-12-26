package com.blink.blinkapi;

import com.blink.blinkapi.controller.DeliveryController;
import com.blink.blinkapi.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlinkApiApplication
		implements CommandLineRunner
{

	final
	DeliveryController deliveryController;

	public BlinkApiApplication(DeliveryController deliveryController) {
		this.deliveryController = deliveryController;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlinkApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Thread.sleep(5000);

		try {
//			Delivery delivery = new Delivery();
//			delivery.setId("1");
//			deliveryController.create(delivery);

		}catch (Exception e){
			;
		}
	}
}


//scp -i C:\Users\fabio\Desktop\EC2\src\main\resources\BlinkKeys.pem C:\Users\fabio\Desktop\EC2\target\blink-0.0.1-SNAPSHOT.jar ec2-user@ec2-35-180-201-185.eu-west-3.compute.amazonaws.com:~
//ssh -i C:\Users\fabio\Desktop\EC2\src\main\resources\BlinkKeys.pem ec2-user@ec2-35-180-201-185.eu-west-3.compute.amazonaws.com
//java -jar blink-0.0.1-SNAPSHOT.jar
//ssh -i C:\Users\fabio\Desktop\EC2\src\main\resources\BlinkKeys.pem ubuntu@ec2-user@ec2-35-180-201-108.eu-west-3.compute.amazonaws.com:~
