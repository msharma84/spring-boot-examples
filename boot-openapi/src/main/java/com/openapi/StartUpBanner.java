package com.openapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartUpBanner {

	private static final Logger LOGGER = LoggerFactory.getLogger(StartUpBanner.class);
	
	@EventListener(ApplicationReadyEvent.class)
    public void contextReadyEvent()
    {
		if(LOGGER.isInfoEnabled()) {
    	LOGGER.info("***************************************************************");
    	LOGGER.info("****************  Application has been started ****************");
        LOGGER.info("***************************************************************");
		}
    }
}
