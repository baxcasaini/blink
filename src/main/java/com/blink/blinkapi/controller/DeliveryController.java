package com.blink.blinkapi.controller;

import java.util.ArrayList;
import java.util.List;

import com.blink.blinkapi.model.DeliveryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.blink.blinkapi.model.Delivery;
import com.blink.blinkapi.repository.DeliveryRepository;

@RestController
@RequestMapping("/deliveries")
//@CrossOrigin(origins = "http://blink-s3.s3-website.eu-west-3.amazonaws.com")
@CrossOrigin(origins = "http://localhost:8080")
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryRepository;

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
        id = "5de25c4073302040c724e19e";
        return getDeliveryFromDTO(deliveryRepository.findById(id).get());
    }

    @PostMapping
    public Delivery create(@RequestBody Delivery delivery) {
        return getDeliveryFromDTO(deliveryRepository.insert(getDTOfromDelivery(delivery)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        deliveryRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAllDeliveries")
    public void deleteAll() {
        deliveryRepository.deleteAll();
    }

    @PatchMapping("/{id}")
    public Delivery update(@PathVariable("id") String id, @RequestBody Delivery delivery) {
        DeliveryDTO deliveryUp = deliveryRepository.findById(id).get();
        if(delivery.getCustomer() != null)
        	deliveryUp.setCustomer(delivery.getCustomer());
        if(delivery.getReceiver() != null)
        	deliveryUp.setReceiver(delivery.getReceiver());
        if(delivery.getPackages() != null)
        	deliveryUp.setPackages(delivery.getPackages());
    	return getDeliveryFromDTO(deliveryRepository.save(deliveryUp));
    }

    // add your api here !!
    
    private Delivery getDeliveryFromDTO(DeliveryDTO dto) {
    	Delivery del = new Delivery();
    	del.setId(dto.getId());
    	del.setCustomer(dto.getCustomer());
    	del.setReceiver(dto.getReceiver());
    	del.setPackages(dto.getPackages());
    	return del;
    }
    private DeliveryDTO getDTOfromDelivery(Delivery dto) {    	
    	return new DeliveryDTO(dto.getCustomer(), dto.getReceiver(), dto.getPackages());
    }
    private List<Delivery> getListDeliveryFromDTO(List<DeliveryDTO> dto){
    	List<Delivery> list = new ArrayList<>();
    	for(DeliveryDTO d : dto) {
    		list.add(getDeliveryFromDTO(d));
    	}
    	return list;
    }

}
