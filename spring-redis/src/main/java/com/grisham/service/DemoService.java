package com.grisham.service;

import com.grisham.dto.DemoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

    private final RedisTemplate<String, Object> redisTemplate;

    public DemoService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //@CachePut(value = "DEMO_CACHE",key="#demoDto.demoId", unless = "#result == null")
    public void saveDataInCache( DemoDto demoDto) {

        String key = "DEMO_CACHE:" + demoDto.getDemoId();
        redisTemplate.opsForValue().set(key, demoDto, Expiration.from(2, TimeUnit.MINUTES));
        LOGGER.info("Adding data into cache...");
    }


    public DemoDto getDataInCache(String id) {
        String key = "DEMO_CACHE:" + id;
        Object cachedProduct = redisTemplate.opsForValue().get(key);
        LOGGER.info("Getting data from cache...");
        return (DemoDto) cachedProduct;
    }
}
