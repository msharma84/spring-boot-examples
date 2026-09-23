package com.grisham.config;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CachingConfiguration implements CachingConfigurer {

    private static Logger LOGGER = LoggerFactory.getLogger(CachingConfiguration.class);

    @Override
    public @Nullable CacheErrorHandler errorHandler() {
        return new CacheErrorHandler() {

            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
                LOGGER.error("[Caching] Error getting key " + key + " from cache " + cache.getName(), exception);
            }

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, @Nullable Object value) {
                LOGGER.error("[Caching] Error putting key " + key + " in cache " + cache.getName(), exception);
            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
                LOGGER.error("[Caching] Error evicting key " + key + " from cache " + cache.getName(), exception);
            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {
                LOGGER.error("[Caching] Error clearing cache " + cache.getName(), exception);
            }
        };
    }
}
