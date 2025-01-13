package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.listener.NotificationListener;
import com.example.demo.model.UserRegistrationModel;
import com.example.demo.service.UserRegistrationService;

@RestController
@RequestMapping("/api/register")
public class UserRegistrationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationListener.class);
	
	private UserRegistrationService registrationService;
	
	public UserRegistrationController(UserRegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@PostMapping
	public String register(@RequestBody UserRegistrationModel model) {
		LOGGER.info(":: USER REGISTRATION ::");
		registrationService.registerUser(model);
		return "";
		
	}

}
