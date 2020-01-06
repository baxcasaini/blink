package com.blink.blinkapi.repository;

import com.blink.blinkapi.model.TrackingDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface TrackingRepository extends MongoRepository<TrackingDTO, String> {


}