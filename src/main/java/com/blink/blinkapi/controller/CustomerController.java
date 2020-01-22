package com.blink.blinkapi.controller;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.blink.blinkapi.model.Customer;
import com.blink.blinkapi.model.login.Account;
import com.blink.blinkapi.repository.CustomerRepository;
import com.blink.blinkapi.security.model.User;

@RestController
@RequestMapping("/customers")
//@CrossOrigin(origins = "http://blink-s3.s3-website.eu-west-3.amazonaws.com")
@CrossOrigin(origins = "http://localhost:8080")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	private  final String URL = "http://localhost:8081/api/signup";

	@GetMapping
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}


	@GetMapping("/id/{id}")
	public Customer getById(@PathVariable("id") String id) {
		//id = "5de25c4073302040c724e19e";
		return customerRepository.findById(id).get();
	}
	
	@GetMapping("/{email}")
	public Customer getByCustomerCode(@PathVariable("email") String email) {
		//id = "5de25c4073302040c724e19e";
		return customerRepository.findByEmail(email);
	}

	@PostMapping
	public Customer create(@RequestBody Customer customer) {
		//CHECK CUSTOMER
		customer.setId(null);
		//FIXME ALE da capire! viene generata una stringa random di 8 char come customer code
		if(customer.getPassword() == null)
			customer.setPassword(RandomStringUtils.random(8, true, true));
		else {
			customer.setPassword(Base64.encodeBase64String(customer.getPassword().getBytes()));
		}
		customer = customerRepository.insert(customer);
		RestTemplate rt = new RestTemplate();
    	if(rt.postForEntity(URL, new Account(customer.getEmail(), customer.getPassword()), Account.class).getStatusCode() != HttpStatus.OK)
    		//GESTIRE ERRORI;
    		System.err.println("ERRORE CUSTOMER NON INSERITO CORRRETTAMENTE NELLA TABELLA USERS");
		return customer;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		//FIXME ALE è necessario? 
		customerRepository.deleteById(id);
	}

	@DeleteMapping("/deleteAllCustomers")
	public void deleteAll() {
		//FIXME ALE Serve?
		customerRepository.deleteAll();
	}

	//FIXME ALE PER IL MOMENTO NON SI PREVEDE UPDATE DA API SU UN CUSTOMER
//	@PatchMapping("/{id}")
//	public Delivery update(@PathVariable("id") String id, @RequestBody Delivery delivery) {
//		DeliveryDTO deliveryUp = customerRepository.findById(id).get();
//		if (delivery.getCustomer() != null)
//			deliveryUp.setCustomer(delivery.getCustomer());
//		if (delivery.getReceiver() != null)
//			deliveryUp.setReceiver(delivery.getReceiver());
//		if (delivery.getPackages() != null)
//			deliveryUp.setPackages(delivery.getPackages());
//		return getDeliveryFromDTO(customerRepository.save(deliveryUp));
//	}

	// add your api here !!


}
