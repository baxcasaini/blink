package com.blink.blinkapi.repository;

import com.blink.blinkapi.model.DeliveryDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface DeliveryRepository extends
        MongoRepository<DeliveryDTO, String> {
}