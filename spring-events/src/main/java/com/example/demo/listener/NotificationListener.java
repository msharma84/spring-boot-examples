package com.example.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.demo.event.UserRegistrationEvent;

@Component
@Order(1)
public class NotificationListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationListener.class);
	
	@Async
	@EventListener
	public void notifyUser(UserRegistrationEvent event) {
		
		LOGGER.info("Thread Name...{}",Thread.currentThread().getName());
		LOGGER.info("Notifying User...{}",event.getName());
	}
}
