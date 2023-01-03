package com.deliveryApp.Delivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories(basePackages = "com.deliveryApp.Delivery.reddis")
public class ReddisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		 JedisConnectionFactory jedisConFactory
	      = new JedisConnectionFactory();
	    jedisConFactory.setHostName("containers-us-west-130.railway.app");
	    jedisConFactory.setPort(6615);
	    jedisConFactory.setPassword("L2BN0BC3XCIgHDsSm0Rg");
	    return jedisConFactory;
	}

	@Bean
	public RedisTemplate<byte[], byte[]> redisTemplate() {
	    RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
	    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
	    template.setConnectionFactory(jedisConnectionFactory());
	    template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
	    return template;
	}
}
