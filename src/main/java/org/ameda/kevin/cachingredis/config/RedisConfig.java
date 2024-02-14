//package org.ameda.kevin.cachingredis.config;/*
//*
//@author ameda
//@project caching-redis
//@package org.ameda.kevin.cachingredis.config
//*
//*/
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurer;
//import org.springframework.cache.interceptor.CacheErrorHandler;
//import org.springframework.cache.interceptor.CacheResolver;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class RedisConfig implements CachingConfigurer {
//
//        @Value("${spring.redis.host}")
//        private String redisHost;
//
//        @Value("${spring.redis.port}")
//        private int redisPort;
//
//        @Bean
//        public JedisConnectionFactory jedisConnectionFactory() {
//            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
//            return new JedisConnectionFactory(redisStandaloneConfiguration);
//        }
//
//        @Bean
//        public RedisTemplate<String, Object> redisTemplate() {
//            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//            redisTemplate.setConnectionFactory(jedisConnectionFactory());
//            redisTemplate.setKeySerializer(new StringRedisSerializer());
//            redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
//            return redisTemplate;
//        }
//
//        @Override
//        @Bean
//        public CacheManager cacheManager() {
//            RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                    .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer<>(Object.class)));
//            return RedisCacheManager.builder(jedisConnectionFactory())
//                    .cacheDefaults(redisCacheConfiguration)
//                    .build();
//        }
//
//        @Override
//        public CacheResolver cacheResolver() {
//            return null;
//        }
//
//        @Override
//        public KeyGenerator keyGenerator() {
//            return null;
//        }
//
//        @Override
//        public CacheErrorHandler errorHandler() {
//            return null;
//        }
//
//}
