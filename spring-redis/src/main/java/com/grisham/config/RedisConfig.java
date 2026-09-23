package com.grisham.config;

import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import tools.jackson.databind.jsontype.BasicPolymorphicTypeValidator;


import java.time.Duration;
import java.util.Map;

@Configuration
public class RedisConfig {

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory){

        // String serializer for keys
        StringRedisSerializer stringSerializer = new StringRedisSerializer();

        var validator = BasicPolymorphicTypeValidator.builder().allowIfSubType(Object.class).build();

        // JSON serializer for values
        GenericJacksonJsonRedisSerializer jsonSerializer = GenericJacksonJsonRedisSerializer.builder()
                .enableDefaultTyping(validator) // Restores type validation (@class metadata)
                .build();

        // Default cache configuration
        RedisCacheConfiguration defaults = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(stringSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(jsonSerializer));

        // Per-cache configurations with different TTLs
        Map<String,RedisCacheConfiguration> cacheConfigurationMap = Map.of(
                "PRODUCT_CACHE",defaults.entryTtl(Duration.ofMinutes(10)),
                "ORDER_CACHE",defaults.entryTtl(Duration.ofMinutes(5)),
                "SHORT_LIVED",defaults.entryTtl(Duration.ofMinutes(1))
        );

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaults)
                .withInitialCacheConfigurations(cacheConfigurationMap)
                .build();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // String serializer for keys
        StringRedisSerializer stringSerializer = new StringRedisSerializer();

        var validator = BasicPolymorphicTypeValidator.builder().allowIfSubType(Object.class).build();

        // JSON serializer for values
        GenericJacksonJsonRedisSerializer jsonSerializer = GenericJacksonJsonRedisSerializer.builder()
                .enableDefaultTyping(validator) // Restores type validation (@class metadata)
                .build();

        // Use String serializer for keys and hash keys
        template.setKeySerializer(stringSerializer);

        // Use JSON serializer for values and hash values
        template.setValueSerializer(jsonSerializer);
        return template;
    }
}
