package com.grisham.config;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.EnumSet;
import java.util.UUID;

@Configuration
public class ProductCodeGenerator implements BeforeExecutionGenerator {

    private static final Logger logger = LoggerFactory.getLogger(ProductCodeGenerator.class);

    private static final String PREFIX = "PRD";

    @Override
    public Object generate(SharedSessionContractImplementor session, Object o, Object o1, EventType eventType) {

        String random = UUID.randomUUID().toString()
                .replace("-", "").substring(0, 20).toUpperCase();
        return PREFIX + random;
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(EventType.INSERT);
    }
}
