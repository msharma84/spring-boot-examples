package com.openapi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.openapi.entity.Foo;
import com.openapi.repos.FooRepository;

@Component
public class StartUpApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(StartUpApplicationListener.class);
	
	@Autowired
	private FooRepository repo;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		List<Foo> list = new ArrayList<>();
		list.add(new Foo(1,"Adarsh"));
		list.add(new Foo(2,"Sachin"));
		list.add(new Foo(3, "Gaurav"));
		list.add(new Foo(4, "Rahul"));
		
		repo.setFooList(list);
		
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("Foo List has been addeded into Repo...");
		}
	}
}
