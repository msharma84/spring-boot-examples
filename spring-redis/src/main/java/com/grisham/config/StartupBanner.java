/*****************************************
* Licensed Materials - Property of
* HCL.
* (c) Copyright HCL Technologies Ltd. * 2016, 2024.
*******************************************/
package com.grisham.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupBanner {

	private static final Logger LOGGER = LogManager.getLogger(StartupBanner.class);

	@EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent()
    {
    	LOGGER.info("***************************************************************");
    	LOGGER.info("****************  Application has been started ****************");
        LOGGER.info("***************************************************************");
    }
}
