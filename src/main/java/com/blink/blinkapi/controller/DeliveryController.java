package com.blink.blinkapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blink.blinkapi.model.Customer;
import com.blink.blinkapi.model.Delivery;
import com.blink.blinkapi.model.DeliveryDTO;
import com.blink.blinkapi.repository.CustomerRepository;
import com.blink.blinkapi.repository.DeliveryRepository;
import com.blink.blinkapi.security.model.UserAuthentication;

@RestController
@RequestMapping("/deliveries")
//@CrossOrigin(origins = "http://blink-s3.s3-website.eu-west-3.amazonaws.com")
@CrossOrigin(origins = "http://localhost:8080")
public class DeliveryController {

	@Autowired
	private DeliveryRepository deliveryRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public List<Delivery> getAll() {
		return getListDeliveryFromDTO(deliveryRepository.findAll());
	}

	@GetMapping(value = "/check")
	public String check() {
		return "Hello JavaSolutionsGuide Readers";
	}

	@GetMapping("/{id}")
	public Delivery getById(@PathVariable("id") String id) {
//        id = "5de25c4073302040c724e19e";
		return getDeliveryFromDTO(deliveryRepository.findById(id).get());
	}

	@PostMapping
	public Delivery create(@RequestBody Delivery delivery) {
		return getDeliveryFromDTO(deliveryRepository.insert(getDTOfromDelivery(delivery)));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		// TODO ALE VALIDAZIONI DATI
		deliveryRepository.deleteById(id);
	}

	@DeleteMapping("/deleteAllDeliveries")
	public void deleteAll() {
		deliveryRepository.deleteAll();
	}

	@PatchMapping("/{id}")
	public Delivery update(@PathVariable("id") String id, @RequestBody Delivery delivery) {
		// TODO ALE Validazioni dei dati
		DeliveryDTO deliveryUp = deliveryRepository.findById(id).get();
		UserAuthentication sessionUser = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
		Customer customer = customerRepository.findByEmail((String) sessionUser.getPrincipal());

		deliveryUp.setCustomer(customer);
		if (delivery.getReceiver() != null)
			deliveryUp.setReceiver(delivery.getReceiver());
		if (delivery.getPackages() != null)
			deliveryUp.setPackages(delivery.getPackages());
		if (delivery.getServiceLevel() != null)
			deliveryUp.setServiceLevel(delivery.getServiceLevel());
		return getDeliveryFromDTO(deliveryRepository.save(deliveryUp));
	}

	// add your api here !!

	private Delivery getDeliveryFromDTO(DeliveryDTO dto) {
		Delivery del = new Delivery();
		del.setId(dto.getId());
		del.setReceiver(dto.getReceiver());
		del.setPackages(dto.getPackages());
		del.setServiceLevel(dto.getServiceLevel());
		return del;
	}

	private DeliveryDTO getDTOfromDelivery(Delivery delivery) {
		UserAuthentication sessionUser = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
		Customer customer = customerRepository.findByEmail((String) sessionUser.getPrincipal());
		
		// TODO ALE Validazioni dei dati, magari con un metodo privato
		if (customer != null)
			return new DeliveryDTO(customer, delivery.getReceiver(), delivery.getPackages(),
					delivery.getServiceLevel());
		else
			throw new IllegalArgumentException("Customer NOT found");
	}

	private List<Delivery> getListDeliveryFromDTO(List<DeliveryDTO> dto) {
		List<Delivery> list = new ArrayList<>();
		for (DeliveryDTO d : dto) {
			list.add(getDeliveryFromDTO(d));
		}
		return list;
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
		
	}
}
