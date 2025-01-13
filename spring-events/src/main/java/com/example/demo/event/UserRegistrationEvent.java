package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class UserRegistrationEvent extends ApplicationEvent {
	
	private String name;
	
	public UserRegistrationEvent(Object source, String name) {
		 super(source);
		 this.name = name;
	}

	public String getName() {
		return name;
	}

}
