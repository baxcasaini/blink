package com.blink.blinkapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blink.blinkapi.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByEmail(String email);
    
    //public Customer findByCustomerCode(String customerCode);

}