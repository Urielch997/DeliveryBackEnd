package com.deliveryApp.Delivery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories(basePackages = "com.deliveryApp.Delivery.reddis")
public class ReddisConfig {
	
	@Value("${spring.redis.username}")
	private String username;
	
	@Value("${spring.redis.password}")
	private String password;
	
	@Value("${spring.redis.url}")
	private String url;
	
	@Value("${spring.redis.port}")
	private  Integer  port;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(url, port);
		redisStandaloneConfiguration.setUsername(username);
		redisStandaloneConfiguration.setPassword(password);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	RedisTemplate<byte[], byte[]> redisTemplate() {
	    RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
	    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
	    template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
	    return template;
	}
}
