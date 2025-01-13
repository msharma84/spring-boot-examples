package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.demo.event.UserRegistrationEvent;
import com.example.demo.model.UserRegistrationModel;

@Service
public class UserRegistrationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationService.class);
	
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    public Boolean registerUser(UserRegistrationModel model) {
    	LOGGER.info(":: USER REGISTRATION SERVICE - registerUser()");
    	eventPublisher.publishEvent(new UserRegistrationEvent(this, model.getName()));
    	return true;
    }
}
