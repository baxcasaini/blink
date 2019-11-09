package com.blink.repository;

import it.snam.pimos.common.events.ValidEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidEventRepository extends CrudRepository<ValidEvent, String> {

}
